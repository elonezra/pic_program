public class Ex2 {
    private static final int R = 0;
    private static final int G = 1;
    private static final int B = 2;

    public static void main(String[] args) {

        int[][][] im = MyImageIO.readImageFromFile("C:\\Users\\elone\\Downloads\\pic_program-master\\pic_program-master\\src\\pic\\image.jpg");

        //MyImageIO.writeImageToFile("/home/elonezra/IdeaProjects/myMath/myMath/EX2/src/imagegray",rgb2gray(im));


        MyImageIO.writeImageToFile("C:\\Users\\elone\\Downloads\\pic_program-master\\pic_program-master\\src\\pic\\smooth", Smooth(im, 0));
        System.out.println("finised");
    }

    /**
     * (0.3*R) + (0.59*G) + (0.11*B) * 255
     *
     * @param im - the picture in array format
     * @return - the pirctuer in grayscale
     */
    public static int[][] rgb2gray(int[][][] im) {
        int[][] res = new int[im[0].length][im[0][0].length];

        for (int i = 0; i < im[0].length; i++) {

            for (int j = 0; j < im[0][0].length; j++) {

                res[i][j] = (int) ((0.3 * im[R][i][j]) + (0.59 * im[G][i][j]) + (0.11 * im[B][i][j])) * 255;
            }

        }

        return res;
    }

    /**
     * @param im - get the pictuer
     * @return the same picture rotated in 90 dgr
     */

    public static int[][][] rotate90(int[][][] im) {

        int[][][] arr = im; // {{1,2,3},{4,5,6},{7,8,9}};
        int[][][] new_arr = new int[3][im[0][0].length][im[0].length];
        int temp;
        int width = im[0].length;
        int height = im[0][0].length;


        for (int k = 0; k < arr.length; k++) {

            for (int i = 0; i < height - 1; i++) {

                for (int j = 0; j < width - 1; j++) {
                    new_arr[k][height - i - 1][width - j - 1] = arr[k][j][i];
                }

            }
        }


        return new_arr;
    }

    /**
     * @param img - the image value
     * @param n   - smoothenes value
     * @return - returm the image with change that each pixle get the avg on nxn
     * around the pixle
     */
    public static int[][][] Smooth(int[][][] img, int n) {

        int line = img[0].length;
        int coulm = img[0][0].length;
        int[][][] new_arr = new int[3][line][coulm];
        int sum = 0;
        int count_val = 0;
        int step = (2*n+1)/2;
        int h_p_smal = 0;
        int w_p_smal = 0;

        int[][][] temp = new int[3][2 * n + 1][2 * n + 1];


        for (int k = 0; k < img.length; k++) {
            for (int i = 0; i < img[0].length-1; i++) {
                for (int j = 0; j < img[0][0].length-1; j++)
                {
                    sum = 0;
                    count_val = 0;

                        for (int p = 0; p < temp[0].length; p++)
                            for (int q = 0; q < temp[0][0].length; q++) {
                                temp[0][p][q] = 0;
                            }




                        for (int p =0; p < temp[0].length; p++)
                            for (int q = 0; q < temp[0][0].length; q++) {
                                w_p_smal = i - step + p;
                                h_p_smal = j - step + q;

                                if ((w_p_smal >= 0 && w_p_smal < img[0].length) && (h_p_smal >= 0 && h_p_smal < img[0][0].length))
                                {
                                    temp[0][p][q] = img[k][w_p_smal ][h_p_smal ];
                                    count_val++;
                                }
                            }



                        for (int p = 0; p < temp[0].length; p++)
                            for (int q = 0; q < temp[0][0].length; q++) {
                                sum += temp[0][p][q];
                            }
                    new_arr[k][i][j] = (sum / count_val);

                }
            }



        }


        return new_arr;

    }

    /**
     * @param factor_h
     * @param factor_w
     * @param im
     * @return
     */
    public static int[][] scaleup(double factor_h, double factor_w, int[][] im) {

        return im;
    }

}
