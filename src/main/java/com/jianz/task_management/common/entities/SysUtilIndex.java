package com.jianz.task_management.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jianz
 * @version 1.0
 * @Description  Util
 * @Email jianz8153.gmail.com
        * @Date 2021/12/1 22:54
        */

@AllArgsConstructor
@Data
public class SysUtilIndex {

    private static List<String> list = new ArrayList<>();

    static {
        list.add("shiXunLou");
        list.add("KeJiLou");
        list.add("17");
    }

    static int[][] edges = {
            {0, 120, 100}, {120, 0, 150}, {100, 150, 0}
    };

     /**
      * @author Jianz
      * @Description 获取所需2点地点名的下标
      * @Return
      * @Date 2021/12/16 10:30
      */
    public static int getLocationIndex(String locationName) {
        for (int i = 0; i < list.size(); i++) {
            if (locationName.equals(list.get(i)))
                return i;
        }
        return -1;
    }

     /**
      * @author Jianz
      * @Description 计算出每个点间最短路径
      * @Return
      * @Date 2021/12/16 10:31
      */
    private static int[][] floyd() {
        int n = edges.length;
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = -1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (edges[i][k] != Integer.MAX_VALUE && edges[k][j] != Integer.MAX_VALUE && edges[i][k] + edges[k][j] < edges[i][j]) {
                        edges[i][j] = edges[i][k] + edges[k][j];
                        path[i][j] = k;
                    }

                }
            }
        }
        return edges;
    }

     /**
      * @author Jianz
      * @Description 返回最短路径
      * @Return
      * @Date 2021/12/16 10:32
      */

     public static int minLength(int index1,int index2){
         int[][] route =  floyd();
         return route[index1][index2];
     }
}
