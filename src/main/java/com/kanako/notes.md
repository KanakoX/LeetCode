### System.arraycopy(src, srcPos, dest, destPos, length);
`System.arraycopy` 是 JVM 自带的数组拷贝，比手写 `for` 循环快，常用来把一段数组搬到另一段。

```java
System.arraycopy(src, srcPos, dest, destPos, length);
```

| 参数        | 含义          |
|-----------|-------------|
| `src`     | 源数组         |
| `srcPos`  | 从源数组哪个下标开始拷 |
| `dest`    | 目标数组        |
| `destPos` | 拷到目标数组哪个下标  |
| `length`  | 拷几个元素       |

```java
System.arraycopy(arr1, 0, ans, 0, i1);      // arr1[0..i1) → ans[0..]
System.arraycopy(arr2, 0, ans, i1, i2);     // arr2[0..i2) → ans[i1..]
```

### LCM GCD
```text
lcm(a, b) = a / gcd(a, b) * b
```

### 容斥原理（Inclusion-Exclusion）

求「至少满足某一个条件」的个数时，直接相加会重复，用容斥去重。

**两个集合：**
```text
|A ∪ B| = |A| + |B| - |A ∩ B|
```

**三个集合：**
```text
|A ∪ B ∪ C|
  = |A| + |B| + |C|
  - |A∩B| - |A∩C| - |B∩C|
  + |A∩B∩C|
```

**规律：** 奇数个集合的交集 → 加；偶数个 → 减。

**和倍数问题结合（如 no3116）：**  
「≤ x 且至少被某个 coins[i] 整除」的个数：
- 单个硬币 i：贡献 `x / coins[i]`（加）
- 两个硬币 i,j：重复部分是 `x / lcm(coins[i], coins[j])`（减）
- 更多同理：贡献 `± x / lcm(子集)`

**用 mask 枚举所有非空子集：**
```java
// n 个元素 → 共 2^n 个子集；mask=0 是空集，从 1 开始
for (int mask = 1; mask < (1 << n); mask++) {
    // mask 的第 i 位为 1 表示选中第 i 个元素
    // (mask & (1 << i)) != 0  → 选中 coins[i]
    // bits = 选中个数；奇数加，偶数减
}
```

| mask (n=2) | 二进制 | 子集 | 操作 |
|------------|--------|------|------|
| 1 | 01 | {coin0} | + |
| 2 | 10 | {coin1} | + |
| 3 | 11 | {coin0, coin1} | − |

例：`coins=[5,2], x=12` → `12/5 + 12/2 - 12/lcm(5,2) = 2+6-1 = 7`

### 递推 vs 动态规划

**结论：** 递推和 DP 不是二选一，而是同一套状态转移的两种写法。

| | 记忆化 DFS（自顶向下） | 填表 DP（自底向上 / 递推） |
|--|--|--|
| 方向 | 从目标往回推，用到才算 | 从起点按顺序填表 |
| 状态 | 如 `dp[x][y]` | 相同 |
| 转移 | 相同 | 相同 |
| 本质 | 自顶向下 DP | 自底向上 DP |

**什么时候能用 DP：** 三个条件都满足
- **最优子结构**：大问题的解由子问题组成
- **重叠子问题**：同一状态会被重复计算
- **无后效性**：当前状态只依赖「之前」的状态

**记忆化 DFS vs 填表 DP 怎么选：**

| 选记忆化 DFS | 选填表 DP |
|--|--|
| 状态转移自然像递归（树、图、回溯） | 状态有明确遍历顺序（网格、一维序列） |
| 只算用到的状态（稀疏状态） | 大部分状态都会用到 |
| 写起来快，思路直观 | 常数更小，无递归栈 |
| 状态维度高、分支多 | 可以压成 O(1) 空间（滚动数组） |

**递推 vs DP：**
- **递推**：已知公式，直接 `for` 循环算（如斐波那契 `f[i]=f[i-1]+f[i-2]`）
- **DP**：需定义状态、转移、边界，再填表；递推是 DP 里最简单的那类

**例（no63 不同路径 II）：**
```java
// 记忆化：谁需要谁才算
memory[x][y] = dfs(x-1,y) + dfs(x,y-1);

// 填表：按 i,j 顺序，左边上边已算好
dp[i][j] = dp[i-1][j] + dp[i][j-1];
```

**刷题建议：**
1. 先想状态 + 转移方程，别先纠结写法
2. 网格 / 线性序列 → 优先填表 DP
3. 树 / 图 / 区间 / 背包 → 常从记忆化 DFS 入手，再改填表
4. 要压空间 → 填表更容易（如 no63 可压成一维 `dp[j]`）

### 字典树 Trie（前缀树）

按字符一层层存的树，适合「查前缀、查单词是否在词典里」。

**结构示意：** `["cat", "car", "do", "dog"]`
```text
          (root)
         /   \
        c     d
        |     |
        a     o
       / \   |\
      t   r  •  g
      •       •
     cat    do  dog
     car
```
- 每条边 = 一个字符；从根往下拼出前缀
- 节点 `isWord = true` 表示「到这里是一个完整单词的结尾」

**核心结构：**
```java
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // 仅小写字母；通用字符可用 HashMap
    boolean isWord;
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isWord = true;
    }

    boolean search(String word) {          // 整词是否存在
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    boolean startsWith(String prefix) {    // 前缀是否存在
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) return null;
            node = node.children[i];
        }
        return node;
    }
}
```

| 操作 | 作用 | 复杂度 |
|------|------|--------|
| `insert` | 插入单词 | O(单词长度) |
| `search` | 整词查询 | O(单词长度) |
| `startsWith` | 前缀查询 | O(前缀长度) |

**为什么快：** 共享前缀（`cat` 和 `car` 共用 `ca`）；查词是从根往下走，走不通立刻停止。

**和 `List.contains` 对比：**

| | `List.contains` | Trie |
|--|--|--|
| 查一个词 | O(词库大小 × 长度) | O(长度) |
| 从某位置找所有匹配词 | 要试很多 `substring` | 沿 Trie 走一遍 |
| 适合 | 词库小、实现简单 | 词库大、前缀匹配多 |

**和 no139（Word Break）结合：** DP 框架不变，只把查词换成 Trie。
```java
// dp[i] = 前 i 个字符能否拆分
Trie trie = new Trie();
for (String w : wordDict) trie.insert(w);

boolean[] dp = new boolean[s.length() + 1];
dp[0] = true;
for (int i = 0; i < s.length(); i++) {
    if (!dp[i]) continue;
    TrieNode node = trie.root;
    for (int j = i; j < s.length(); j++) {
        int idx = s.charAt(j) - 'a';
        if (node.children[idx] == null) break;  // 前缀断了
        node = node.children[idx];
        if (node.isWord) dp[j + 1] = true;
    }
}
return dp[s.length()];
```

**记忆要点：**
1. 每个节点 = 一个前缀
2. `isWord` 标记完整单词（前缀存在 ≠ 单词存在）
3. 走不通 → `null`，提前结束
4. 典型题：Word Break、Implement Trie、单词搜索 II

