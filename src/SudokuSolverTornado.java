import uk.ac.manchester.tornado.api.TornadoExecutionPlan;
import uk.ac.manchester.tornado.api.annotations.Parallel;

import java.util.*;

public class SudokuSolverTornado {

    public void solve(int[][] board) {
        List<List<Integer>> missingNumbers = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            List<Integer> chars = new ArrayList<>();
            for (int val : board[i]) {
                if (val != 0) {
                    chars.add(val);
                }
            }
            List<Integer> missingRow = new ArrayList<>();
            missingNumbers.add(missingRow);
            for (int j = 1; j <= 9; j++) {
                if (!chars.contains(j)) {
                    missingRow.add(j);
                }
            }
        }
        System.out.println(missingNumbers);

        // Find permutations
        Map<Integer, List<List<Integer>>> combinations = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            List<List<Integer>> rowCombinations = new ArrayList<>();
            List<Integer> missingRow = missingNumbers.get(i);
            findCombinations(missingRow, new ArrayList<>(), rowCombinations);
            combinations.put(i, rowCombinations);
        }

        // Create solution space
        List<List<List<Integer>>> solutionSpace = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            int[] row = board[i];
            List<List<Integer>> candidateRowSolution = new ArrayList<>();
            List<List<Integer>> rowSolutions = combinations.get(i);
            for (List<Integer> rowSolution : rowSolutions) {
                List<Integer> appliedSolution = applySolution(row, rowSolution);
                candidateRowSolution.add(appliedSolution);
            }
            solutionSpace.add(candidateRowSolution);
        }

        // Parallelize the traversal of the solution space
        traverseSolutionSpaceParallel(solutionSpace);
    }

    // TornadoVM compatible method to traverse the solution space in parallel
    private void traverseSolutionSpaceParallel(List<List<List<Integer>>> solutionSpace) {

        // Define the size of each dimension (assuming each list has the same size)
        int size0 = solutionSpace.get(0).size();
        int size1 = solutionSpace.get(1).size();
        int size2 = solutionSpace.get(2).size();
        int size3 = solutionSpace.get(3).size();
        int size4 = solutionSpace.get(4).size();
        int size5 = solutionSpace.get(5).size();
        int size6 = solutionSpace.get(6).size();
        int size7 = solutionSpace.get(7).size();
        int size8 = solutionSpace.get(8).size();

        // Flattened index array for parallelization
        int totalSize = size0 * size1 * size2 * size3 * size4 * size5 * size6 * size7 * size8;
        int[] indices = new int[totalSize];
        List<List<Integer>>[] potentialSolutions = new ArrayList[totalSize];

        // Generate potential solutions in parallel using TornadoVM
        uk.ac.manchester.tornado.api.TaskGraph  schedule = new uk.ac.manchester.tornado.api.TaskGraph ("sudoku")
                .task("t0", SudokuSolverTornado::generatePotentialSolutions, indices, potentialSolutions, solutionSpace, totalSize)
                .streamOut(potentialSolutions);

        uk.ac.manchester.tornado.api.TornadoExecutionPlan  executionPlan = new uk.ac.manchester.tornado.api.TornadoExecutionPlan (schedule);
        executionPlan.execute();
    }

    // TornadoVM-compatible parallel method to generate potential solutions
    @Parallel
    private static void generatePotentialSolutions(int[] indices, List<List<Integer>>[] potentialSolutions,
                                                   List<List<List<Integer>>> solutionSpace, int totalSize) {
        int size0 = solutionSpace.get(0).size();
        int size1 = solutionSpace.get(1).size();
        int size2 = solutionSpace.get(2).size();
        int size3 = solutionSpace.get(3).size();
        int size4 = solutionSpace.get(4).size();
        int size5 = solutionSpace.get(5).size();
        int size6 = solutionSpace.get(6).size();
        int size7 = solutionSpace.get(7).size();
        int size8 = solutionSpace.get(8).size();

        // Calculate the indices and generate potential solutions
        for (int idx = 0; idx < totalSize; idx++) {
            int i0 = idx % size0;
            int i1 = (idx / size0) % size1;
            int i2 = (idx / (size0 * size1)) % size2;
            int i3 = (idx / (size0 * size1 * size2)) % size3;
            int i4 = (idx / (size0 * size1 * size2 * size3)) % size4;
            int i5 = (idx / (size0 * size1 * size2 * size3 * size4)) % size5;
            int i6 = (idx / (size0 * size1 * size2 * size3 * size4 * size5)) % size6;
            int i7 = (idx / (size0 * size1 * size2 * size3 * size4 * size5 * size6)) % size7;
            int i8 = (idx / (size0 * size1 * size2 * size3 * size4 * size5 * size6 * size7)) % size8;

            List<List<Integer>> potentialSolution = new ArrayList<>();
            potentialSolution.add(solutionSpace.get(0).get(i0));
            potentialSolution.add(solutionSpace.get(1).get(i1));
            potentialSolution.add(solutionSpace.get(2).get(i2));
            potentialSolution.add(solutionSpace.get(3).get(i3));
            potentialSolution.add(solutionSpace.get(4).get(i4));
            potentialSolution.add(solutionSpace.get(5).get(i5));
            potentialSolution.add(solutionSpace.get(6).get(i6));
            potentialSolution.add(solutionSpace.get(7).get(i7));
            potentialSolution.add(solutionSpace.get(8).get(i8));

            potentialSolutions[idx] = potentialSolution;
        }
    }

    private void isValidSolution(List<List<Integer>> potentialSolution) {
        for (List<Integer> row : potentialSolution) {
            if (!row.containsAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))) {
                return;
            }
        }

        for (int i = 0; i < potentialSolution.size(); i++) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> row : potentialSolution) {
                col.add(row.get(i));
            }
            if (!col.containsAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))) {
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

        for (List<Integer> row : potentialSolution) {
            System.out.println(row);
        }
    }

    private boolean checkRange(int i, int i1, int i2, int i3, List<List<Integer>> potentialSolution) {
        List<Integer> cells = new ArrayList<>();
        for (int j = i; j <= i1; j++) {
            for (int k = i2; k <= i3; k++) {
                cells.add(potentialSolution.get(j).get(k));
            }
        }
        return cells.containsAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    private List<Integer> applySolution(int[] row, List<Integer> rowSolution) {
        List<Integer> result = new ArrayList<>();
        List<Integer> rowSolutionClone = new ArrayList<>(rowSolution);
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                result.add(rowSolutionClone.remove(0));
            } else {
                result.add(row[i]);
            }
        }
        return result;
    }

    public void findCombinations(List<Integer> missingRow, List<Integer> accumulator, List<List<Integer>> rowCombinations) {
        for (int i = 0; i < missingRow.size(); i++) {
            List<Integer> missingRownClone = new ArrayList<>(missingRow);
            Integer remove = missingRownClone.remove(i);
            List<Integer> accumulatorClone = new ArrayList<>(accumulator);
            accumulatorClone.add(remove);
            findCombinations(missingRownClone, accumulatorClone, rowCombinations);
        }
        if (missingRow.size() == 0) {
            rowCombinations.add(accumulator);
        }
    }

    public static void main(String[] args) {
        int[][] b = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        new SudokuSolver().solve(b);
    }
}