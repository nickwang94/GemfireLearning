package com.nick.gemfire;

import com.nick.gemfire.buslogic.Loader;
import com.nick.gemfire.domain.Book;
import com.nick.gemfire.domain.BookOrder;
import com.nick.gemfire.domain.Customer;
import com.nick.gemfire.domain.InventoryItem;
import org.apache.geode.cache.Region;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:cache-config.xml"})
@ActiveProfiles({"basic"})
public class BasicValidationTest {

    @Resource(name = "Customer")
    private Region<Long, Customer> customerRegion;

    @Resource(name = "Book")
    private Region<Long, Book> bookRegion;

    @Resource(name = "BookOrder")
    private Region<Long, BookOrder> orderRegion;

    @Resource(name = "InventoryItem")
    private Region<Long, InventoryItem> inventoryRegion;

    @Autowired private Loader loader;

    @Before
    public void seedRegions() {
        loader.populateCustomers(customerRegion);
        loader.populateBooks(bookRegion);
        loader.populateBookOrders(orderRegion);
        loader.populateInventory(inventoryRegion);
    }

    @Test
    public void customerKariPowellShouldExist() {
        Customer nickwang = customerRegion.get(9527L);
        assertThat(nickwang).isNotNull();
        assertThat(nickwang.getFirstName()).isEqualTo("Nick");
        assertThat(nickwang.getLastName()).isEqualTo("Wang");
    }

}
