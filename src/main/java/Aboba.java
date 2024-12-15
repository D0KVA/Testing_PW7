public class Aboba{
    private int countOccurrences(String word, char letter) {
        int count = 0;
        for (char c : word.toCharArray()){
            if (c == letter) {
                count++;
            }
        }
        return count;
    }

    public String findWordWithMostI(String a){
        String[] words = a.split("\\s+");
        String result = "";
        int Mcount = 0;

        for (String word : words){
            int count = countOccurrences(word, 'И');
            if (count > Mcount){
                Mcount = count;
                result = word;
            }
        }
        return result;
    }


    public int maxDiagonalSum(int[][] matrix) {
        int firstSum = 0;
        int secondSum = 0;
        int a = matrix.length;

        for (int i = 0; i < a; i++){
            firstSum += matrix[i][i];
            secondSum += matrix[i][a - 1 - i];
        }

        return Math.max(firstSum, secondSum);
    }

    public String getInitials(String str) {
        String initials = "";
        String[] words = str.split("\\s+");

        for (String word : words){
            if (!word.isEmpty()){
                initials += Character.toUpperCase(word.charAt(0));
            }
        }
        return initials;
    }
}