public class rectangle {
    private int  width;
    private int  height;

    public rectangle(int width, int height){
                this.width = width;
                this.height = height;
    }

    public int findArea(){// method
        return this.height * this.width;
    }
}

