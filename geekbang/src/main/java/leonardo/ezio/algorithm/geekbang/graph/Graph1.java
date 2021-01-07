package leonardo.ezio.algorithm.geekbang.graph;

import java.util.*;

/**
 * @ClassName : Graph1
 * @Author : LeonardoEzio
 * @Date : 2021-01-07 22:05
 * @Description : 图的表示以及BFS和DFS (邻接表表示)
 */
public class Graph1 {


    // 顶点个数
    private int v;

    // 邻接表
    private LinkedList<Integer> adj[];

    public Graph1(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);

    }


    /***
    * description : <广度优先搜索算法>
    *
    * @methodName : bfs
    * @param s 起点
    * @param t 终点
    * @return {@link }
    * @date : 2021/1/7 22:13
    **/
    public void bfs(int s , int t){
        if (s == t){
            return;
        }
        //顶点是否已经访问标识
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //队列存储已经被访问 但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //prev 数组记录搜索路径  标识当前节点是从哪个前驱节点遍历过来
        int[] pre = new int[v];
        for (int i = 0 ; i < v ; i++){
           pre[i] = -1;
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            LinkedList<Integer> related = adj[poll];
            for (int j = 0 ; j < related.size() ; j++){
                Integer rel = related.get(j);
                if (!visited[rel]){
                    if (t == rel){
                        //打印路径
                        print(pre,s,t);
                        return;
                    }
                    pre[rel] = poll;
                    queue.add(rel);
                    visited[rel] = true;
                }
            }

        }

    }


    /***
     * description : <广度优先搜索算法2  调用的print方法不一样>
     *
     * @methodName : bfs
     * @param s 起点
     * @param t 终点
     * @return {@link }
     * @date : 2021/1/7 22:13
     **/
    public void bfs2(int s , int t){
        if (s == t){
            return;
        }
        //是否已经走到终点
        boolean over = false;
        //顶点是否已经访问标识
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //队列存储已经被访问 但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //prev 数组记录搜索路径  标识当前节点是从哪个前驱节点遍历过来
        int[] pre = new int[v];
        for (int i = 0 ; i < v ; i++){
            pre[i] = -1;
        }
        while (!queue.isEmpty() && !over){
            Integer poll = queue.poll();
            LinkedList<Integer> related = adj[poll];
            for (int j = 0 ; j < related.size() ; j++){
                Integer rel = related.get(j);
                if (!visited[rel]){
                    pre[rel] = poll;
                    queue.add(rel);
                    visited[rel] = true;
                    if (rel == t){
                        over = true;
                    }
                }
            }
        }
        print2(pre,s,t);
    }

    /***
    * description : <打印路径 -- 递归打印>
    *
    * @methodName : print
    * @param pre 路径记录
    * @param s 起点
    * @param t 终点
    * @return {@link  }
    * @date : 2021/1/7 22:26
    **/
    private void print(int [] pre,int s , int t){
        if (pre[t] != -1 && t != s){
            print(pre,s,pre[t]);
        }
        System.out.println(t + " ");
    }

    /***
     * description : <打印路径 -- 普通打印>
     *
     * @methodName : print2
     * @param pre 路径记录
     * @param s 起点
     * @param t 终点
     * @return {@link  }
     * @date : 2021/1/7 22:26
     **/
    private void print2(int [] pre,int s , int t){
        List<Integer> ways = new ArrayList<>();
        //添加终点
        int temp = t;
        ways.add(t);
        while (pre[t] != -1){
            t = pre[t];
            ways.add(t);
        }
        Collections.reverse(ways);
        StringBuffer waysBuf = new StringBuffer();
        ways.forEach(way -> {
            waysBuf.append(way);
            if (way != temp){
                waysBuf.append("-->");
            }
        });
        System.out.println(waysBuf.toString());
    }


    public static void main(String[] args) {
        Graph1 graph = new Graph1(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        //广度优先搜索
        graph.bfs2(0,7);

        // 深度优先搜索
//        graph.dfs(0, 6);
    }


}
