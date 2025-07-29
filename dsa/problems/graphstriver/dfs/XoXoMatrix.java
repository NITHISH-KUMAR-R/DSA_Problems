package dsa.problems.graphstriver.dfs;

public class XoXoMatrix {
    // User function Template for Java
     static  int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};
        public static  void dfs(int i,int j , char mat[][]){
            if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j]!='O'){
                return;
            }
            mat[i][j] ='S';
            for(int d [] : dir){
                dfs(i+d[0],j+d[1],mat);
            }


        }
        static char[][] fill(char mat[][]) {

            int m  = mat.length;
            int n  = mat[0].length;

            for(int i =0;i<n;i++){
                dfs(0,i,mat);
                dfs(m-1,i,mat);
            }
            for(int i =0;i<m;i++){
                dfs(i,0,mat);
                dfs(i,n-1,mat);
            }
            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    if(mat[i][j]=='O'){
                        mat[i][j] ='X';
                    }else if(mat[i][j] =='S'){
                        mat[i][j] = 'O';
                    }
                }
            }

            return mat;


        }
    }

