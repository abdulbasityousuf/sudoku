import java.util.*;
import java.util.regex.Pattern;

public class SudokuSolverOptimized {

    public void solve(String[][] board) {
        List<List<String>> missingNumbers = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            List<String> chars = Arrays.asList(board[i]);
            List<String> missingRow = new ArrayList<>();
            missingNumbers.add(missingRow);
            for (int j = 1; j <= 9; j++) {
                if (!chars.contains(String.valueOf(j))) {
                    missingRow.add(String.valueOf(j));
                }
            }
        }
        System.out.println(Arrays.deepToString(missingNumbers.toArray()));

        //next find permutations
        Map<Integer, List<List<String>>> combinations = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            List<List<String>> rowCombinations = new ArrayList<>();
            List<String> missingRow = missingNumbers.get(i);
            findCombinations(missingRow, new ArrayList<>(), rowCombinations);
            combinations.put(i, rowCombinations);
        }

        //next create solution space
        List<List<List<String>>> solutionSpace = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String[] row = board[i];
            List<List<String>> candidateRowSolution = new ArrayList<>();
            List<List<String>> rowSolutions = combinations.get(i);
            for (List<String> rowSolution : rowSolutions) {
                List<String> appliedSolution = applySolution(row, rowSolution);
                candidateRowSolution.add(appliedSolution);
            }
            solutionSpace.add(candidateRowSolution);
        }

        //next traverse solution space
        traverseSolutionSpace(solutionSpace);

    }

    private void traverseSolutionSpace(List<List<List<String>>> solutionSpace) {
        for (int i0 = 0; i0 < solutionSpace.get(0).size(); i0++) {
            System.out.println("Progress i0 " + i0 + " of " + solutionSpace.get(0).size());
            for (int i1 = 0; i1 < solutionSpace.get(1).size(); i1++) {
                if (checkColDups(Arrays.asList(solutionSpace.get(0).get(i0), solutionSpace.get(1).get(i1)))) {
                    continue;
                } else {
                    System.out.println("Progress i1 " + i0 + " " + i1 + " of " + solutionSpace.get(1).size());
                }
                for (int i2 = 0; i2 < solutionSpace.get(2).size(); i2++) {
                    List<List<String>> rows = Arrays.asList(
                            solutionSpace.get(0).get(i0),
                            solutionSpace.get(1).get(i1),
                            solutionSpace.get(2).get(i2));
                    if (checkColDups(rows) ||
                            !checkRange(0, 2, 0, 2, rows) ||
                            !checkRange(0, 2, 3, 5, rows) ||
                            !checkRange(0, 2, 6, 8, rows)) {
                        continue;
                    } else {
                        System.out.println("Progress i2 " + i0 + " " + i1 + " " + i2 + " of " + solutionSpace.get(2).size());
                    }
                    for (int i3 = 0; i3 < solutionSpace.get(3).size(); i3++) {
                        if (checkColDups(Arrays.asList(
                                solutionSpace.get(0).get(i0),
                                solutionSpace.get(1).get(i1),
                                solutionSpace.get(2).get(i2),
                                solutionSpace.get(3).get(i3)))) {
                            continue;
                        }
                        for (int i4 = 0; i4 < solutionSpace.get(4).size(); i4++) {
                            if (checkColDups(Arrays.asList(
                                    solutionSpace.get(0).get(i0),
                                    solutionSpace.get(1).get(i1),
                                    solutionSpace.get(2).get(i2),
                                    solutionSpace.get(3).get(i3),
                                    solutionSpace.get(4).get(i4)))) {
                                continue;
                            }
                            for (int i5 = 0; i5 < solutionSpace.get(5).size(); i5++) {
                                List<List<String>> rows1 = Arrays.asList(
                                        solutionSpace.get(0).get(i0),
                                        solutionSpace.get(1).get(i1),
                                        solutionSpace.get(2).get(i2),
                                        solutionSpace.get(3).get(i3),
                                        solutionSpace.get(4).get(i4),
                                        solutionSpace.get(5).get(i5));
                                if (checkColDups(rows1) ||
                                        !checkRange(3, 5, 0, 2, rows1) ||
                                        !checkRange(3, 5, 3, 5, rows1) ||
                                        !checkRange(3, 5, 6, 8, rows1)) {
                                    continue;
                                }
                                for (int i6 = 0; i6 < solutionSpace.get(6).size(); i6++) {
                                    if (checkColDups(Arrays.asList(
                                            solutionSpace.get(0).get(i0),
                                            solutionSpace.get(1).get(i1),
                                            solutionSpace.get(2).get(i2),
                                            solutionSpace.get(3).get(i3),
                                            solutionSpace.get(4).get(i4),
                                            solutionSpace.get(5).get(i5),
                                            solutionSpace.get(6).get(i6)))) {
                                        continue;
                                    }
                                    for (int i7 = 0; i7 < solutionSpace.get(7).size(); i7++) {
                                        if (checkColDups(Arrays.asList(
                                                solutionSpace.get(0).get(i0),
                                                solutionSpace.get(1).get(i1),
                                                solutionSpace.get(2).get(i2),
                                                solutionSpace.get(3).get(i3),
                                                solutionSpace.get(4).get(i4),
                                                solutionSpace.get(5).get(i5),
                                                solutionSpace.get(6).get(i6),
                                                solutionSpace.get(7).get(i7)))) {
                                            continue;
                                        }
                                        for (int i8 = 0; i8 < solutionSpace.get(8).size(); i8++) {
                                            List<List<String>> potentialSolution = new ArrayList<>();
                                            potentialSolution.add(solutionSpace.get(0).get(i0));
                                            potentialSolution.add(solutionSpace.get(1).get(i1));
                                            potentialSolution.add(solutionSpace.get(2).get(i2));
                                            potentialSolution.add(solutionSpace.get(3).get(i3));
                                            potentialSolution.add(solutionSpace.get(4).get(i4));
                                            potentialSolution.add(solutionSpace.get(5).get(i5));
                                            potentialSolution.add(solutionSpace.get(6).get(i6));
                                            potentialSolution.add(solutionSpace.get(7).get(i7));
                                            potentialSolution.add(solutionSpace.get(8).get(i8));
                                            isValidSolution(potentialSolution);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }

    private boolean checkColDups(List<List<String>> rows) {
        Pattern p = Pattern.compile("\\w*(\\w)\\w*\\1+\\w*");

        for (int j = 0; j < 9; j++) {
            String col = "";
            for (int i = 0; i < rows.size(); i++) {
                col += rows.get(i).get(j);
            }
            if (p.matcher(col).matches()) {
                return true;
            }
        }
        return false;
    }

    private void isValidSolution(List<List<String>> potentialSolution) {
        for (List<String> row : potentialSolution) {
            if (!row.containsAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"))) {
                return;
            }
        }

        for (int i = 0; i < potentialSolution.size(); i++) {
            List<String> col = new ArrayList<>();
            for (List<String> row : potentialSolution) {
                col.add(row.get(i));
            }
            if (!col.containsAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"))) {
                return;
            }
        }

        if (!checkRange(0, 2, 0, 2, potentialSolution) ||
                !checkRange(0, 2, 3, 5, potentialSolution) ||
                !checkRange(0, 2, 6, 8, potentialSolution) ||
                !checkRange(3, 5, 0, 2, potentialSolution) ||
                !checkRange(3, 5, 3, 5, potentialSolution) ||
                !checkRange(3, 5, 6, 8, potentialSolution) ||
                !checkRange(6, 8, 0, 2, potentialSolution) ||
                !checkRange(6, 8, 3, 5, potentialSolution) ||
                !checkRange(6, 8, 6, 8, potentialSolution)) {
            return;
        }
        for (List<String> row : potentialSolution) {
            System.out.println(row);
        }
        System.exit(0);
    }

    private boolean checkRange(int i, int i1, int i2, int i3, List<List<String>> potentialSolution) {
        List<String> cells = new ArrayList<>();
        for (int j = i; j <= i1; j++) {
            for (int k = i2; k <= i3; k++) {
                cells.add(potentialSolution.get(j).get(k));
            }
        }
        return cells.containsAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }


    private List<String> applySolution(String[] row, List<String> rowSolution) {
        List<String> result = new ArrayList<>();
        List<String> rowSolutionClone = new ArrayList<>();
        rowSolutionClone.addAll(rowSolution);
        for (int i = 0; i < row.length; i++) {
            if (row[i].equals(".")) {
                result.add(rowSolutionClone.remove(0));
            } else {
                result.add(row[i]);
            }
        }
        return result;
    }

    public void findCombinations(List<String> missingRow, List<String> accumulator, List<List<String>> rowCombinations) {
        for (int i = 0; i < missingRow.size(); i++) {
            List<String> missingRownClone = new ArrayList<>();
            missingRownClone.addAll(missingRow);
            String remove = missingRownClone.remove(i);
            List<String> accumulatorClone = new ArrayList<>();
            accumulatorClone.addAll(accumulator);
            accumulatorClone.add(remove);
            findCombinations(missingRownClone, accumulatorClone, rowCombinations);
        }
        if (missingRow.size() == 0) {
            rowCombinations.add(accumulator);
        }
    }

    public static void main(String[] args) {
//        String[][] b = new String[][]{
//                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
//                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
//                {".", "9", "8", ".", ".", ".", ".", "6", "."},
//                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
//                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
//                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
//                {".", "6", ".", ".", ".", ".", "2", "8", "."},
//                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
//                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        
//        String[][] b = new String[][]
//               {{"5","3","4","6",".","8","9","1","2"},
//                {"6","7",".","1","9","5","3","4","8"},
//                {"1","9","8","3","4","2","5","6","."},
//                {"8","5","9","7","6",".","4","2","3"},
//                {"4","2","6","8","5","3","7","9","."},
//                {".","1","3","9",".","4","8","5","6"},
//                {"9",".","1","5","3","7","2","8","4"},
//                {"2","8",".","4","1","9","6","3","5"},
//                {"3","4","5","2","8","6","1",".","9"}};

                String[][] b = new String[][]
               {{".","1","6",".","2",".","9",".","8"},
                {".",".",".","8",".",".",".","4","."},
                {"9",".",".",".",".",".",".","5","."},
                {"6",".",".","5",".",".","1",".","3"},
                {".",".","2",".",".","7",".",".","."},
                {".",".",".",".",".",".",".","9","."},
                {".","3",".",".","5",".",".",".","."},
                {".",".",".",".",".",".",".",".","4"},
                {"1",".",".","3",".",".","8",".","6"}};


        new SudokuSolverOptimized().solve(b);

//        ArrayList<List<String>> rowCombinations = new ArrayList<>();
//        new SudokuSolver().findCombinations(Arrays.asList("1", "2", "3"), new ArrayList<>(), rowCombinations);
//        System.out.println(rowCombinations);

    }
}

