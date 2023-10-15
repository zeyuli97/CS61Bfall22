public class Mystery {
    public static int myth(int[] inputa, int k) {
        int x = inputa[k];
        int answer = k;
        int index = k + 1;
        while (index < inputa.length){
            if (inputa[index] > x){
                x = inputa[index];
                answer = index;
            }
            index = index + 1;
        }
        return answer;
    }

    public static int[] sortArray(int[] inputarray){
        int index = 0;
        while (index < inputarray.length){
            int target_index = myth(inputarray, index);
            int temp = inputarray[index];
            inputarray[index] = inputarray[target_index];
            inputarray[target_index] = temp;
            index = index + 1;
        }
        return inputarray;
    }

    public static int recursiveMyth(int[] inputarray, int k){

        return recursiveMythHelper(inputarray, k, k);
    }
    
    public static int recursiveMythHelper(int[] inputarray, int i, int ans){
        if (i >= inputarray.length - 1){
            return ans;
        }
        int index = i + 1;
        if (inputarray[ans] < inputarray[index]){
            ans = index;
            return recursiveMythHelper(inputarray, index, ans);
        }

        return recursiveMythHelper(inputarray, index, ans);


    }
}
