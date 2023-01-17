//Taehyun Park taehyun.park.1@stonybrook.edu
import java.util.Arrays;
public class Corrector {

    private static String[] wordList;
    private static int wordIndexOf;
    private static String checkingWord;

    public static void divideInput(String sentences) {
        wordList = sentences.split(" |[,]|[.]|[!]");
        checkingWord = wordList[wordIndexOf].toLowerCase();
    }

    public static String nextWord() {
        wordIndexOf++;
        checkingWord = wordList[wordIndexOf].toLowerCase();
        return checkingWord;

    }

    public static boolean checkInDict(String[] dict, String word) {
        for (String i : dict) {
            if (word == null) {
                ;
            } else if (i.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static String[] checkSwaps(String rawWord) {
        String[] aryS = new String[10];
        int count = 0;

        for (int i = 0; i < rawWord.length() - 1; i++) {
            char[] cs = rawWord.toCharArray();
            char temp = cs[i];
            cs[i] = cs[i + 1];
            cs[i + 1] = temp;

            String swappedWord = new String(cs);

            if (checkInDict(DictDoc.dict, swappedWord)) {
                aryS[count] = swappedWord;
                count++;
            }
        }
        String[] suggestSwap = new String[count];
        for (int j = 0; j < suggestSwap.length; j++) {
            suggestSwap[j] = aryS[j];
        }
        return suggestSwap;
    }

    public static String[] checkInserts(String rawWord) {
        String[] aryI = new String[10];
        int count = 0;

        for (int i = 0; i < rawWord.length(); i++) {
            char[] ci = rawWord.toCharArray();
            char[] arr1 = Arrays.copyOf(ci, i);
            char[] arr2 = Arrays.copyOfRange(ci, i, rawWord.length());
            char[] arrNew = new char[rawWord.length() + 1];

            for (char j = 'a'; j <= 'z'; j++) {
                for (int s = 0; s < arr1.length; s++) {
                    arrNew[s] = arr1[s];
                }
                arrNew[arr1.length] = j;
                for (int k = 0; k < arr2.length; k++) {
                    arrNew[arr1.length + k + 1] = arr2[k];
                }

                String insertedWord = new String(arrNew);

                if (checkInDict(DictDoc.dict, insertedWord)) {
                    aryI[count] = insertedWord;
                    count++;
                }
            }
        }
        String[] suggestInsert = new String[count];
        for (int j = 0; j < suggestInsert.length; j++) {
            suggestInsert[j] = aryI[j];
        }
        return suggestInsert;
    }

    public static String[] checkDeletes(String rawWord) {
        String[] aryD = new String[10];
        int count = 0;

        for (int i = 0; i < rawWord.length(); i++) {
            char[] cd = rawWord.toCharArray();
            char[] arr3 = Arrays.copyOf(cd, i);
            char[] arr4 = Arrays.copyOfRange(cd, i + 1, rawWord.length() + 1);
            char[] arrNew1 = new char[rawWord.length() - 1];

            for (int k = 0; k < arr3.length; k++) {
                arrNew1[k] = arr3[k];
            }
            for (int j = 0; j < arrNew1.length - arr3.length; j++) {
                arrNew1[j + arr3.length] = arr4[j];
            }

            String deletedWord = new String(arrNew1);

            if (checkInDict(DictDoc.dict, deletedWord)) {
                aryD[count] = deletedWord;
                count++;
            }
        }

        String[] suggestDel = new String[count];
        for (int j = 0; j < suggestDel.length; j++) {
            suggestDel[j] = aryD[j];
        }
        return suggestDel;
    }


    public static void main(String[] args) {
        divideInput(DictDoc.doc);
        while (wordIndexOf < wordList.length) {
            if (checkInDict(DictDoc.dict, checkingWord)) {
                if (wordIndexOf == wordList.length - 1) {
                    break;
                } else {
                    nextWord();
                    continue;
                }
            } else {
                if ((checkSwaps(checkingWord).length == 0) && (checkInserts(checkingWord).length == 0)
                        && (checkDeletes(checkingWord).length == 0)) {
                    if (wordIndexOf == wordList.length - 1) {
                        break;
                    } else {
                        nextWord();
                        continue;
                    }
                } else {
                System.out.println(checkingWord + " is misspelled. Possible:");
                for (String i : checkSwaps(checkingWord)) {
                    System.out.println(i);
                }
                for (String i : checkInserts(checkingWord)) {
                    System.out.println(i);
                }
                for (String i : checkDeletes(checkingWord)) {
                    System.out.println(i);
                }
                if (wordIndexOf == wordList.length - 1) {
                    break;
                } else {
                    nextWord();
                }
            }
        }
        }
    }
}
