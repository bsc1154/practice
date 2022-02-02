public class rain{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int answer = 0;
        int [] wa = new int[w];
        for(int i=0;i<w;i++){
            wa[i] = sc.nextInt();
        }

        for(int j=1;j<w-1;j++){
            int current = wa[j];
            int leftMax = current;
            int rightMax = current;
            //좌측 max값 찾기
            for(int k=j-1;k>=0;k--){
                if(wa[k]>current){
                    leftMax = Math.max(leftMax, wa[k]);
                }
            }
            //우측 max값 찾기
            for(int k=j+1;k<w;k++){
                if(wa[k]>current){
                    rightMax = Math.max(rightMax, wa[k]);
                }
            }
            if(Math.min(leftMax,rightMax)>current){
                answer+= (Math.min(leftMax,rightMax)-current);
            }
        }
        System.out.println(answer);


    }
}
