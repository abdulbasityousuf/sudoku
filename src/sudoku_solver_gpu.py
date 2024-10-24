import time

import numpy as np
from numba import cuda, int32

# Define the size of the Sudoku board
N = 9

# CUDA kernel to validate the number placement in rows, columns, and 3x3 grids
@cuda.jit
def validate_placement_kernel(board, row, col, num, valid):
    # Determine the 3x3 grid position
    start_row = (row // 3) * 3
    start_col = (col // 3) * 3

    # Validate row and column
    for i in range(N):
        if board[row, i] == num or board[i, col] == num:
            valid[0] = 0
            return

    # Validate 3x3 grid
    for i in range(3):
        for j in range(3):
            if board[start_row + i, start_col + j] == num:
                valid[0] = 0
                return

    valid[0] = 1  # Valid placement


def is_valid(board, row, col, num):
    # Create a device array to store validation result
    valid = cuda.to_device(np.array([1], dtype=np.int32))

    # Launch the CUDA kernel
    validate_placement_kernel[(1, 1), (1, 1)](board, row, col, num, valid)

    return valid.copy_to_host()[0] == 1


def find_empty_location(board):
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                return (i, j)
    return None


def solve_sudoku(board):
    empty = find_empty_location(board)
    if not empty:
        return True  # Puzzle solved
    row, col = empty

    for num in range(1, 10):
        if is_valid(board, row, col, num):
            board[row, col] = num
            if solve_sudoku(board):
                return True
            board[row, col] = 0  # Backtrack

    return False


def main():
    # Example Sudoku puzzle as a 2D numpy array
    sudoku_board = np.array([
        [0, 0, 0, 0, 1, 3, 0, 0, 0],
        [0, 0, 0, 6, 8, 0, 0, 0, 2],
        [0, 0, 6, 0, 0, 0, 0, 0, 0],
        [2, 0, 0, 4, 7, 0, 0, 0, 5],
        [4, 0, 0, 8, 0, 8, 0, 0, 0],
        [0, 0, 5, 0, 6, 0, 0, 3, 0],
        [0, 0, 0, 3, 0, 5, 0, 2, 6],
        [0, 0, 3, 0, 0, 0, 8, 0, 1],
        [0, 0, 0, 0, 8, 0, 4, 0, 0]
    ])

    current_time = time.time()
    if solve_sudoku(sudoku_board):
        print("Solution found:")
        for row in sudoku_board:
            print(row)
    else:
        print("No solution exists.")
    print("Total time: " + str((time.time() - current_time)))




if __name__ == "__main__":
    main()
