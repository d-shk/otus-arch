package ru.dmsh.otus.matrix.multiplication.impl;


import ru.dmsh.otus.matrix.model.Matrix;
import ru.dmsh.otus.matrix.model.MatrixIndex;
import ru.dmsh.otus.matrix.multiplication.IMatrixMultiplicationService;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * MatrixConcurrentMultiplicationService is a service for multithreading calculation of matrix multiplication
 */
public class MatrixConcurrentMultiplicationService implements IMatrixMultiplicationService {

    private final Thread[] threads;
    private Queue<MatrixIndex> tasks;
    private final Matrix firstMatrix, secondMatrix;
    private Matrix resultMatrix;

    /**
     * @param firstMatrix - first factor of matrix multiplication
     * @param secondMatrix - second factor of matrix multiplication
     * @param amountOfThreads - amount of threads which will be used for matrix multiplication
     */
    public MatrixConcurrentMultiplicationService(final Matrix firstMatrix,
                                                 final Matrix secondMatrix,
                                                 int amountOfThreads) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;

        int amountOfElements = firstMatrix.getRowNum() * secondMatrix.getColNum();
        resultMatrix = new Matrix(firstMatrix.getRowNum(), secondMatrix.getColNum());

        // tasks is a variable for blocking space for multithreading.
        tasks = new ArrayBlockingQueue<>(amountOfElements);

        threads = new Thread[amountOfThreads];

        for(int i=0; i<amountOfThreads; i++) {
            threads[i] = new Thread(new Runner(i));
        }
    }

    public Matrix calculate() {
        try {
            for (int i = 0; i < firstMatrix.getRowNum(); i++) {
                for (int j = 0; j < secondMatrix.getColNum(); j++) {
                    tasks.add(new MatrixIndex(i, j));
                }
            }

            for (Thread thread : threads) thread.start();
            for (Thread thread : threads) thread.join();

        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted");
        }

        return resultMatrix;
    }

    /**
     * Built-in class for realisation of multiplication thread work
     */
    class Runner implements Runnable {
        int threadNumber;

        public Runner(int n) {
            threadNumber = n;
        }

        @Override
        public void run() {
            MatrixIndex index;
            int row;
            int column;
            while ((index = tasks.poll())!=null) {
                row = index.getRow();
                column = index.getCol();
                for (int k = 0; k < secondMatrix.getRowNum(); k++) {
                    resultMatrix.getMatrix()[row][column] +=
                            firstMatrix.getMatrix()[row][k] * secondMatrix.getMatrix()[k][column];
                }
            }
            System.out.println("Thread "+threadNumber+" finished");
        }
    }
}
