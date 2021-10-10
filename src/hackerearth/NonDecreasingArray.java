package hackerearth;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] generatedArray = generateArray(5, 10,1);

        for(int i : generatedArray){
            System.out.print(" " + i);
        }

        System.out.println("");

        int[] nonDecreasingArray = nonDecreasingArray(generatedArray);

        for(int i : nonDecreasingArray){
            System.out.print(" " + i);
        }


    }

    public static int[] nonDecreasingArray(int[] inputArray){
        int[] nonDecreasingArray = new int[inputArray.length];

        for(int i = 0; i < inputArray.length;i++){
            if(i==0){
                nonDecreasingArray[i] = inputArray[i];
            }else{
                if(inputArray[i] < nonDecreasingArray[i-1]){
                    for(int j = inputArray[i]; j < Integer.MAX_VALUE; j+=inputArray[i]){
                        if(j >= inputArray[i] && j >= nonDecreasingArray[i-1]){
                            nonDecreasingArray[i] = j;
                            break;
                        }
                    }
                }else{
                    nonDecreasingArray[i] = inputArray[i];
                }
            }
        }

        return nonDecreasingArray;
    }

    public static int[] generateArray(int sizeOfArray , int max, int min){
        int[] arrayGenerated = new int[sizeOfArray];

        for(int i = 0; i < sizeOfArray ; i++){
            arrayGenerated[i] = (int)(Math.random()*(max-min+1)+min);
        }

        return arrayGenerated;
    }
}


/*
Problem
You are given an array
A
 consisting of
N
 positive integers. Your task is to find an array
B
 of length
N
 satisfying the following conditions:


B
i
>
0
 for all
1
≤
i
≤
N

B
i
≤
B
i
+
1
, for all
1
≤
i
<
N

B
i
 is divisible by
A
i
 for all
1
≤
i
≤
N

∑
i
=
1
N
B
i
 is minimum
You are given
T
 test cases.

Input format

The first line contains a single integer
T
 denoting the number of test cases.
The first line of each test case contains a single integer
N
 denoting the length of the array.
The second line of each test case contains
N
 space-separated integers denoting the integer array
A
.
Output format

For each test case (in a separate line), print
N
 space-separated integers denoting
B
1
,
B
2
,
.
.
,
B
N
. If there are multiple answers, you can print any of them. It is guaranteed that under the given constraints at least 1
B
 exists.

Constraints


1
≤
T
≤
1000
1
≤
N
≤
2.5
×
10
5
1
≤
A
i
≤
10
9
Sum of N over all test cases does not exceed
7.5
×
10
5
Sample Input
2
3
2 1 3
2
5 1
Sample Output
2 2 3
5 5
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
Self explanatory.
 */
