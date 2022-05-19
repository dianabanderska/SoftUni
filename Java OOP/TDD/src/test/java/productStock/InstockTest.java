package productStock;

import org.junit.Before;
import org.junit.Test;
import productStock.Instock;
import productStock.Product;
import productStock.ProductStock;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {
    private static final String LABEL = "test_label";
    private static final double PRICE = 9.99;
    private static final int QUANTITY = 1;

    private ProductStock stock;
    private Product defaultProduct;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.defaultProduct = new Product(LABEL, PRICE, QUANTITY);
    }

    //add
    //adds product only if there is no product with the same label

    //contains
    //return true or false if the product is present or not

    @Test
    public void testAddProductShouldAddTheProductInsideTheStock() {
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductNotPresentAndThenTrueAfterAdded() {
        assertFalse(stock.contains(defaultProduct));
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }

    @Test
    public void testAddProductShouldNotAddTheSameProductASecondTime() {
        stock.add(defaultProduct);
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testCountShouldReturnTheCorrectNumberOfProducts() {
        //Asserts zero when empty
        assertEquals(0, stock.getCount());
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenOnlyOnePresent() {
        stock.add(defaultProduct);
        Product product = stock.find(0);
        assertNotNull(product);
        assertEquals(defaultProduct.getLabel(), product.getLabel());
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenTheProductIsInBetweenOtherProduct() {
        stubProducts();
        Product product = stock.find(4);
        assertNotNull(product);
        assertEquals("test_label_5", product.getLabel());
    }

    @Test
    public void testFindByIndexShouldReturnTheCorrectProductWhenTheProductIsTheLastOne() {
        stubProducts();
        Product product = stock.find(9);
        assertNotNull(product);
        assertEquals("test_label_10", product.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldFailWhenGreaterThanNine() {
        stubProducts();
        stock.find(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldFailWhenStockIsEmpty() {
        stock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldFailWhenIndexIsNegative() {
        stubProducts();
        stock.find(-1);
    }

    @Test
    public void testChangeQuantityShouldUpdateTheCorrectProductWithTheCorrectAmount() {
        stubProducts();
        stock.add(defaultProduct);
        assertEquals(QUANTITY, defaultProduct.getQuantity());
        stock.changeQuantity(defaultProduct.getLabel(), 12);
        assertEquals(12, defaultProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailIfProductIsNotPresent() {
        stubProducts();
        stock.changeQuantity(defaultProduct.getLabel(), 12);
    }

    @Test
    public void testFindByLabelShouldReturnTheCorrectProduct() {
        stubProducts();
        stock.add(defaultProduct);
        Product byLabel = stock.findByLabel(defaultProduct.getLabel());
        assertNotNull(byLabel);
        assertEquals(defaultProduct.getLabel(), byLabel.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldFailWhenProductWithSuchLabelIsNotPresent() {
        stubProducts();
        stock.findByLabel(defaultProduct.getLabel());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenStockIsZero() {
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(0);

        List<Product> productList = createListFromIterable(iterable);
        assertTrue(productList.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenParamIsTooLarge() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(11);

        List<Product> productList = createListFromIterable(iterable);
        assertTrue(productList.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheCorrectNumberOfProducts() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(8);
        List<Product> productList = createListFromIterable(iterable);
        assertEquals(8, productList.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheObjectsSorted() {
        stubProducts();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(8);
        List<Product> productList = createListFromIterable(iterable);
        Set<String> expectedLabelsSorted = productList.stream()
                .map(Product::getLabel).collect(Collectors.toCollection(TreeSet::new));

        int i = 0;
        for (String expectedLabel : expectedLabelsSorted) {
            assertEquals(expectedLabel, productList.get(i++).getLabel());
        }
    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyCollectionIfNoSuchRangePresent() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(9999, 99999));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllInRangeShouldReturnTheCorrectRange() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(10.00, 30.00));
        assertEquals(6, products.size());
        for (Product product : products) {
            assertTrue(product.getPrice() > 10.00 && product.getPrice() <= 30.00);
        }
    }

    @Test
    public void testFindAllInRangeShouldReturnProductsOrderedByPriceDescending() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllInRange(10.00, 30.00));

        List<Product> expected = products.stream()
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                .collect(Collectors.toList());

        assertEquals(expected, products);
    }

    @Test
    public void testFindAllByPriceShouldReturnTheCorrectPricedObjects() {
        stubProducts();
        stock.add(defaultProduct);
        List<Product> products = createListFromIterable(stock.findAllByPrice(10.00));
        assertEquals(4, products.size());
        for (Product product : products) {
            assertEquals(10.00, product.getPrice(), 0.00);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionIfNoSuchPricedObjectsExist() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByPrice(99.99));
        assertTrue(products.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldFailIfTheCountIsGreaterThanTheTotalNumberOfProducts() {
        stubProducts();
        stock.findFirstMostExpensiveProducts(stock.getCount() + 1);
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnTheCorrectMostExpensiveProducts() {
        List<Product> expected = stubProducts()
                .stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(5)
                .collect(Collectors.toList());

        List<Product> products = createListFromIterable(stock.findFirstMostExpensiveProducts(5));
        assertEquals(expected, products);
    }

    @Test
    public void testFindAllByQuantityShouldReturnAnEmptyCollectionIfNoProductHasSuchQuantity() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByQuantity(100));
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllByQuantityShouldReturnOnlyProductsWithTheMatchingQuantity() {
        stubProducts();
        List<Product> products = createListFromIterable(stock.findAllByQuantity(10));
        assertEquals(5, products.size());
        for (Product product : products) {
            assertEquals(10, product.getQuantity());
        }
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        List<Product> expected = stubProducts();

        Iterator<Product> iterator = stock.iterator();
        assertNotNull(iterator);

        int index = 0;
        while (iterator.hasNext()) {
            Product product = iterator.next();
            assertEquals(expected.get(index++).getLabel(), product.getLabel());
        }
    }

    private List<Product> createListFromIterable(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

    private List<Product> stubProducts() {
        List<Product> products = Arrays.asList
                (new Product("test_label_1", 10.00, 2),
                        new Product("test_label_2", 20.00, 2),
                        new Product("test_label_3", 30.00, 10),
                        new Product("test_label_4", 15.00, 10),
                        new Product("test_label_5", 17.00, 2),
                        new Product("test_label_6", 14.99, 10),
                        new Product("test_label_7", 10.01, 2),
                        new Product("test_label_8", 10.00, 10),
                        new Product("test_label_9", 10.00, 2),
                        new Product("test_label_10", 10.00, 10));

        for (Product product : products) {
            stock.add(product);
        }
        return products;
    }
}