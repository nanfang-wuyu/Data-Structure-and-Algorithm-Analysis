/*
package dsaalab9;

import java.util.Scanner;
import java.util.ArrayList;

public class MANLY_A
{
    static class Vertex
    {
        int key;
        ArrayList<Integer> neighbor =new ArrayList<>();//Adjacency list
        boolean known;
        long distance;//int can be double or other tpe of data
    }

    public static ArrayList<Vertex> unknownVertexList =new ArrayList<>();
    public static int[][] matrix;
    public static Vertex[] vertexList;
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int vertexCounts=input.nextInt(),roadCounts=input.nextInt();
        vertexList=new Vertex[vertexCounts+1];
        for(int i=1;i<vertexCounts+1;i++)
        {
            vertexList[i]=new Vertex();
            vertexList[i].key=i;
        }
        matrix=new int[vertexCounts+1][vertexCounts+1];
        for (int i=1;i<vertexCounts+1;i++)
        {
            for (int j=1;j<vertexCounts+1;j++)
            {
                matrix[i][j]=-1;
            }
        }
        for (int i=0;i<roadCounts;i++)
        {
            int vertex1=input.nextInt();
            int vertex2=input.nextInt();
            int distance=input.nextInt();
            buildMatrix(matrix,vertex1,vertex2,distance);
            vertexList[vertex1].neighbor.add(vertex2);
            vertexList[vertex2].neighbor.add(vertex1);
        }
        int begin=input.nextInt(),end=input.nextInt();
        dijkstra(vertexList[begin]);
        if (vertexList[end].distance==Long.MAX_VALUE)
        {
            System.out.print(-1);
        }else
        {
            System.out.print(vertexList[end].distance);
        }
    }

    public static void buildMatrix(int[][] matrix, int vertex1, int vertex2, int distance)
    {
        matrix[vertex1][vertex2]=distance;
        matrix[vertex2][vertex1]=distance;
    }

    public static void dijkstra (Vertex s)
    {
        for (int i=1;i<vertexList.length;i++)
        {
            unknownVertexList.add(vertexList[i]);
        }
        for(int i = 0;i<unk;i++)
        {   //unknownVertexList.get(i).
            v.distance =Long.MAX_VALUE;
            v.known=false;
        }
        s.distance =0;

        while (!unknownVertexList.isEmpty())
        {
            Vertex smallestVertex=unknownVertexList.get(0);
            for(Vertex temp:unknownVertexList)
            {
                if (temp.distance<=smallestVertex.distance)
                {
                    smallestVertex=temp;
                }
            }

            smallestVertex.known=true;
            unknownVertexList.remove(smallestVertex);
            for (int w:smallestVertex.neighbor)
            {
                int cvw=matrix[w][smallestVertex.key];
                if (!vertexList[w].known&&cvw!=-1)
                {
                    if (vertexList[w].distance>smallestVertex.distance+cvw)
                    {
                        vertexList[w].distance=smallestVertex.distance+cvw;
                    }
                }
            }
        }
    }
}*/
