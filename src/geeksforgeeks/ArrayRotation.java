package geeksforgeeks;

public class ArrayRotation {

    public static void main(String[] args) {

        int[] inputArray = generateArray(1000000, 1, 100);
        for(int i : inputArray){
            System.out.print(" " + i);
        }

        System.out.println("");
        long start = System.currentTimeMillis();
        inputArray = leftRotateArray(inputArray,100);
        long end  = System.currentTimeMillis();
        for(int i : inputArray){
            System.out.print(" " + i);
        }
        System.out.println("");
        long difference = end - start;
        System.out.println("Time Taken by this algorithm : " + String.valueOf(difference));
    }

    public static int[] leftRotateArray(int[] inputArray, int shiftby){

        int[] tempArray = new int[shiftby];

        for(int i = 0; i < shiftby; i++){
            tempArray[i] = inputArray[i];
        }

        for(int j = 0; j < inputArray.length-shiftby;j++){
            inputArray[j] = inputArray[j+shiftby];
        }

        int temp = 0;
        int beginningIndex = inputArray.length - shiftby;
        for(int k = beginningIndex; k < inputArray.length; k++){
            inputArray[k] = tempArray[temp];
            temp += 1;
        }
        return inputArray;
    }

    public static int[] generateArray(int sizeOfArray , int max, int min){
        int[] arrayGenerated = new int[sizeOfArray];

        for(int i = 0; i < sizeOfArray ; i++){
            arrayGenerated[i] = (int)(Math.random()*(max-min+1)+min);
        }

        return arrayGenerated;
    }
}
