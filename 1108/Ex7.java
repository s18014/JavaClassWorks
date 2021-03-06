class Ex7{

    public int ex7_1(int a, int b){
        return Math.min(a, b);
    }

    public int ex7_1(int a, int b, int c){
        int min = Math.min(a, b);
        min = Math.min(min, c);
        return min;
    }

    public int ex7_1(int [] a){
        int min = a[0];
        for (int i: a) {
            min = Math.min(min, i);
        }
        return min;
    }

    public int ex7_2(int x){
        return Math.abs(x);
    }

    public long ex7_2(long x){
        return Math.abs(x);
    }

    public float ex7_2(float x){
        return Math.abs(x);
    }

    public double ex7_2(double x){
        return Math.abs(x);
    }

    public String ex7_3(byte x){
        String binary = Integer.toBinaryString(Byte.toUnsignedInt(x));
        int zeroLen = Integer.toBinaryString(Byte.MAX_VALUE).length() - binary.length();
        String padding = "";
        for (int i = 0; i <= zeroLen; i++) {
            padding += "0";
        }
        return padding + binary;
    }

    public String ex7_3(short x){
        String binary = Integer.toBinaryString(Short.toUnsignedInt(x));
        int zeroLen = Integer.toBinaryString(Short.MAX_VALUE).length() - binary.length();
        String padding = "";
        for (int i = 0; i <= zeroLen; i++) {
            padding += "0";
        }
        return padding + binary;
    }

    public String ex7_3(int x){
        String binary = Integer.toBinaryString(x);
        int zeroLen = Integer.toBinaryString(Integer.MAX_VALUE).length() - binary.length();
        String padding = "";
        for (int i = 0; i <= zeroLen; i++) {
            padding += "0";
        }
        return padding + binary;
    }

    public String ex7_3(long x){
        String binary = Long.toBinaryString(x);
        int zeroLen = Long.toBinaryString(Long.MAX_VALUE).length() - binary.length();
        String padding = "";
        for (int i = 0; i <= zeroLen; i++) {
            padding += "0";
        }
        return padding + binary;

    }
}