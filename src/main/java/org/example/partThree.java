package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class partThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        int numExist=Integer.parseInt(br.readLine());
        int[][] graph= new int[4][];
        for(int i=0;i<numExist;i++){
            Integer[] exist= Stream.of(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            graph[i][0]=exist[0];
            graph[i][1]=exist[1];
            graph[i][2]=exist[2];
            graph[i][3]=0;
        }
        int numBuild=Integer.parseInt(br.readLine());
        for(int i=0;i<numBuild;i++){
            Integer[] exist= Stream.of(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            graph[i][0]=exist[0];
            graph[i][1]=exist[1];
            graph[i][2]=exist[2];
            graph[i][3]=exist[3];
        }

        Integer[] request=Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
