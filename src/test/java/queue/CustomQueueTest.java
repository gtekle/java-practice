package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomQueueTest {

    CustomQueue underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomQueue();
    }

    @Test
    void givenValidQueue_whenEnqueue_theAddElementToQueue() {
        underTest.enqueue(2);

        assertEquals(1, underTest.queueSize());
    }

    @Test
    void givenFullQueue_whenEnqueue_theThrowException() {
        populateFullQueue();
        underTest.enqueue(17);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> underTest.enqueue(18));
        assertEquals("The element can't be added because the queue is full: Overflow", exception.getMessage());
    }

    @Test
    void givenNonEmptyQueue_whenDequeue_theRemoveElementFromQueue() {
        underTest.enqueue(3);
        underTest.dequeue();
        assertEquals(0, underTest.queueSize());
    }

    @Test
    void givenEmptyQueue_whenDequeue_theThrowException() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> underTest.dequeue());
        assertEquals("The queue is empty: Underflow", exception.getMessage());
    }

    @Test
    void givenEmptyQueue_whenIsEmpty_thenReturnTrue() {
        assertTrue(underTest.isEmpty());
    }

    @Test
    void givenNonEmptyQueue_whenIsEmpty_thenReturnTrue() {
        underTest.enqueue(1);
        assertFalse(underTest.isEmpty());
    }

    @Test
    void givenNonFullQueue_whenIsFull_thenReturnFalse() {
        assertFalse(underTest.isFull());
    }

    @Test
    void givenFullQueue_whenIsFull_thenReturnTrue() {
        populateFullQueue();
        assertTrue(underTest.isFull());
    }

    private void populateFullQueue() {
        int initialQueueCapacity = 16;
        for (int i = 0; i < initialQueueCapacity; i++) {
            underTest.enqueue(i);
        }
    }
}