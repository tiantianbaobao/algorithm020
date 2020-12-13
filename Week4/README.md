####学习笔记
#####深度优先遍历和广度优先遍历
-  泛化的`dfs`和`bfs`的代码模板
   - dfs
   ```
    //主要是判断在不在已经被访问的节点中
   public void dfs(node) {
       if node in visited {
         return;
       }
       visited.add(node);
       dfs(node.left);
       dfs(node.right);
       //泛化到多子节点
       // for(node in childrenNode of node) {
       //   dfs(node); 
       //}      
   }
   ```
   - bfs
   ```
     //采用队列来处理
    public void bfs(Node node){ 
        Queue<Node> queue = new Queue<>();
        quque.add(node);
        while(!queue.isEmpty()){
            //precess
            Node node = queue.remove();
            dosomething();
            if (node.left ! = null) {
                queue.add(node.left);
            }
            if (node.right ! = null) {
                queue.add(node.rght);
            }
            //泛化到多节点，采用for-loop -> queue.add();
        }
        //既然涉及到queue，不同的插入顺序或导致不一样的内容
   ```
-  深度优先实现层级遍历
   - 代码模板（递归模式）
   ```java
   //重点是利用层级深度做文章
   private static void _dfs(TreeNode treeNode, int level, List<List<Integer>> res) {
           if (res.size() == level) {
               res.add(new ArrayList<>());
           }
           res.get(level).add(treeNode.value);
           if (treeNode.left != null) {
               _dfs(treeNode.left, level + 1, res);
           }
           if (treeNode.right != null) {
               _dfs(treeNode.right, level + 1, res);
           }
       }
   ```
   - 广度代码模板
   ```java
   public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> allResults = new ArrayList<>();
       if (root == null) {
           return allResults;
       }
       Queue<TreeNode> nodes = new LinkedList<>();
       nodes.add(root);
       while (!nodes.isEmpty()) {
           int size = nodes.size();
           List<Integer> results = new ArrayList<>();
           for (int i = 0; i < size; i++) {
               TreeNode node = nodes.poll();
               results.add(node.val);
               if (node.left != null) {
                   nodes.add(node.left);
               }
               if (node.right != null) {
                   nodes.add(node.right);
               }
           }
           allResults.add(results);
       }
       return allResults;
   }

   ```

####二分查找
-   适用特征
    - 单调递增(递减)，保证单调性
    - 有上下边界，类似于数组中的夹逼法，不停的获取中间位置并比较目标值和中间值的大小，已决定是从大集合里继续还是小集合里继续查找
    - 能够通过下标索引引用
-   代码模板
```java

public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    //return right;
    return left;
}
```

