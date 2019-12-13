public class Ex2
{
    private static final int R = 0;
    private static final int G = 1;
    private static final int B = 2;

    public static void main(String[] args)
    {

        int [][][] im =  MyImageIO.readImageFromFile("/home/elonezra/IdeaProjects/myMath/myMath/EX2/src/image.jpg");

             MyImageIO.writeImageToFile("/home/elonezra/IdeaProjects/myMath/myMath/EX2/src/imagegray",rgb2gray(im));
    }

    /**
     * (0.3*R) + (0.59*G) + (0.11*B) * 255
     * @param im - the picture in array format
     * @return  - the pirctuer in grayscale
     */
    public static int[][] rgb2gray(int[][][] im)
    {
        int [][] res = new int[im[0].length][im[0][0].length];

        for (int i = 0; i < im[0].length; i++) {

            for (int j = 0; j < im[0][0].length; j++) {

                   res [i][j] = (int) ((0.3*im[R][i][j]) + (0.59*im[G][i][j]) + (0.11*im[B][i][j]) )*255;
            }

        }

        return  res;
    }

    /**
     *
     * @param im - get the pictuer
     * @return the same picture rotated in 90 dgr
     */

    public static int[][][] rotate90(int[][][] im)
    {

           int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
    int temp;
    int width = arr[0].length;
    int height = arr.length;
    
    for(int i = 0; i < arr.length; i++)
    {
  
      for(int j = 0; j < arr[0].length;j++)
      {
        System.out.print(arr[i][j]);
      }
       System.out.println("");
    }
    
    /////////////////////////////////
    
     for(int i = 0; i < arr.length/2; i++)
    {
  
      for(int j = 0; j < arr[0].length;j++)
      {
       		temp =  arr[i][j];
        	arr[i][j] = arr[height -j-1][width -i-1];
        	arr[height -j-1][width -i-1] = temp;
        	
      }
       
    }
    
    
    //////////////////////////////////
    
        System.out.println("------------------------");
     for(int i = 0; i < arr.length; i++)
    {
  
      for(int j = 0; j < arr[0].length;j++)
      {
        System.out.print(arr[i][j]);
      }
       System.out.println("");
    }
    

        return im;
    }


    /**
     *
     * @param img - the image value
     * @param n - smoothenes value
     * @return - returm the image with change that each pixle get the avg on nxn around the pixle
     */
    public static int [][][] Smooth(int[][][] img,int n)
    {

        return img;
    }

    /**
     *
     * @param factor_h
     * @param factor_w
     * @param im
     * @return
     */
    public static int[][] scaleup(double factor_h, double factor_w, int [][]im)
    {

        return im;
    }

}
