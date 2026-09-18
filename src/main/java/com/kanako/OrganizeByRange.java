package com.kanako;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 将 com.kanako 下的 noXxx 题解目录，按每 10 题一组归档。
 * 例：no31 → no31_40/no31
 * <p>
 * 区间算法：题号 n 落入 [((n-1)/10)*10+1, 起点+9]，目录名 no{start}_{end}。
 * 会同步改写 .java 的 package 声明。
 * <p>
 * 用法：在 IDE 中运行 main，或指定 kanako 根目录为第一个参数。
 * 默认扫描本类所在模块的 src/main/java/com/kanako。
 */
public class OrganizeByRange {

    private static final Pattern NO_DIR = Pattern.compile("^no(\\d+)$");
    private static final Pattern PACKAGE_LINE =
            Pattern.compile("^(\\s*package\\s+)([\\w.]+)(\\s*;)", Pattern.MULTILINE);

    public static void main(String[] args) throws IOException {
        Path kanako = resolveKanakoRoot(args);
        if (!Files.isDirectory(kanako)) {
            System.err.println("目录不存在: " + kanako);
            return;
        }

        System.out.println("扫描: " + kanako.toAbsolutePath());
        int moved = 0;

        try (Stream<Path> stream = Files.list(kanako)) {
            for (Path dir : stream
                    .filter(Files::isDirectory)
                    .sorted(Comparator.comparing(p -> p.getFileName().toString()))
                    .toList()) {
                Matcher m = NO_DIR.matcher(dir.getFileName().toString());
                if (!m.matches()) {
                    continue;
                }

                int num = Integer.parseInt(m.group(1));
                int start = ((num - 1) / 10) * 10 + 1;
                int end = start + 9;
                String rangeName = "no" + start + "_" + end;
                Path rangeDir = kanako.resolve(rangeName);
                Path target = rangeDir.resolve(dir.getFileName());

                if (Files.exists(target)) {
                    System.out.println("跳过(目标已存在): " + dir.getFileName() + " -> " + rangeName);
                    continue;
                }

                Files.createDirectories(rangeDir);
                Files.move(dir, target, StandardCopyOption.ATOMIC_MOVE);
                rewritePackages(target, "com.kanako." + rangeName + "." + dir.getFileName());
                System.out.println("移动: " + dir.getFileName() + " -> " + rangeName + "/" + dir.getFileName());
                moved++;
            }
        }

        System.out.println("完成，共移动 " + moved + " 个目录。");
    }

    private static Path resolveKanakoRoot(String[] args) {
        if (args.length > 0) {
            return Path.of(args[0]);
        }
        Path cwd = Path.of("").toAbsolutePath();
        Path candidate = cwd.resolve("src/main/java/com/kanako");
        if (Files.isDirectory(candidate)) {
            return candidate;
        }
        return cwd;
    }

    /** 递归更新目录内所有 .java 的 package 为 newPackage */
    private static void rewritePackages(Path root, String newPackage) throws IOException {
        try (Stream<Path> files = Files.walk(root)) {
            for (Path file : files.filter(p -> p.toString().endsWith(".java")).toList()) {
                String content = Files.readString(file, StandardCharsets.UTF_8);
                Matcher pkg = PACKAGE_LINE.matcher(content);
                if (!pkg.find()) {
                    System.out.println("  警告: 无 package 声明 -> " + file);
                    continue;
                }
                String updated = pkg.replaceFirst("$1" + Matcher.quoteReplacement(newPackage) + "$3");
                if (!updated.equals(content)) {
                    Files.writeString(file, updated, StandardCharsets.UTF_8);
                    System.out.println("  更新 package: " + file.getFileName() + " -> " + newPackage);
                }
            }
        }
    }
}
