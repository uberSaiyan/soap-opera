import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class PyramidMax {
    public static void main(String[] args) {
        Pyramid<Integer> py = new Pyramid<>();
        Integer[][] layers = {
            {3}, 
            {7, 1}, 
            {2, 4, 6}, 
            {8, 5, 9, 3}};
        for (Integer[] layer : layers) {
            py.addLayer(layer);
        }
        py.print();
        System.out.println(py.getMaximumSum());
    }
}

class Pyramid<E> {
    private PyramidNode<E> topNode;

    Pyramid() {
    }

    Pyramid(PyramidNode<E> topNode) {
        this.topNode = topNode;
    }

    Pyramid<E> getLeftPyramid() {
        return new Pyramid<E>(topNode.getLeftNode());
    }

    Pyramid<E> getRightPyramid() {
        return new Pyramid<E>(topNode.getRightNode());
    }

    int getMaximumSum() {
        if (topNode.getElement() instanceof Number) {
            if (getNumberOfLayers() == 1) {
                return (int) topNode.getElement();
            }
            else {
                return (int) topNode.getElement() + Math.max(getLeftPyramid().getMaximumSum(), getRightPyramid().getMaximumSum());
            }
        }
        else {
            return -1;
        }
    }

    int getNumberOfLayers() {
        int layers = 0;
        PyramidNode<E> currNode = topNode;
        while (currNode != null) {
            currNode = currNode.getLeftNode();
            layers++;
        }
        return layers;
    }

    Object[] getLayer(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Layers start from 1");
        }
        else if (n == 1) {
            Object[] temp = new Object[1];
            temp[0] = topNode;
            return temp;
        }
        else {
            Object[] temp = getLayer(n - 1);
            Object[] result = new Object[n];
            result[0] = ((PyramidNode<E>)temp[0]).getLeftNode();
            for (int i = 0; i < temp.length; i++) {
                result[i+1] = ((PyramidNode<E>)temp[i]).getRightNode();
            }
            return result;
        }
    }

    void addLayer(E[] elements) {
        int layers = getNumberOfLayers();
        if (elements.length == layers + 1) {
            if (topNode == null) {
                topNode = new PyramidNode<E>(elements[0]);
            }
            else {
                Object[] temp = getLayer(layers);
                for (int i = 0; i < temp.length; i++) {
                    PyramidNode<E> node = (PyramidNode<E>) temp[i];
                    node.setLeftNode(new PyramidNode<E>(elements[i]));
                    node.setRightNode(new PyramidNode<E>(elements[i+1]));
                }
            }
        }
        else {
            throw new IllegalArgumentException("Layer has an invalid number of elements");
        }
    }

    void printLayer(int n) {
        Object[] temp = getLayer(n);
        for (Object obj : temp) {
            PyramidNode<E> node = (PyramidNode<E>) obj;
            System.out.print(node.getElement() + " ");
        }
        System.out.println();
    }

    void print() {
        int height = getNumberOfLayers();
        for (int i = 1; i <= height; i++) {
            printLayer(i);
        }
    }
}

class PyramidNode<E> {
    private E element;
    private PyramidNode<E> leftNode;
    private PyramidNode<E> rightNode;

    PyramidNode(E element) {
        this.element = element;
    }

    PyramidNode(E element, PyramidNode<E> leftNode, PyramidNode<E> rightNode) {
        this.element = element;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    //getters
    E getElement() {
        return element;
    }

    PyramidNode<E> getLeftNode() {
        return leftNode;
    }

    PyramidNode<E> getRightNode() {
        return rightNode;
    }

    //setters
    void setElement(E element) {
        this.element = element;
    }

    void setLeftNode(PyramidNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    void setRightNode(PyramidNode<E> rightNode) {
        this.rightNode = rightNode;
    }
}
