package array;

public class Alpha {
    public int num;
    public Alpha(){
    }
    public Alpha(int num){
        this.num = num;
    }

    public class Beta extends Alpha{
        int p;
        public Beta(){
            this.p =1;
            }
        }
}
