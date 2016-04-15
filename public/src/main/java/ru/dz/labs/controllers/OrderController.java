package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.Constants;
import ru.dz.labs.aspects.annotation.AttsInclude;
import ru.dz.labs.aspects.annotation.CatalogInclude;
import ru.dz.labs.model.Addresses;
import ru.dz.labs.model.Orders;
import ru.dz.labs.model.Telephones;
import ru.dz.labs.model.Users;
import ru.dz.labs.pojo.SumAndCount;
import ru.dz.labs.services.*;

import java.util.Date;


@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    UsersService usersService;
    @Autowired
    TelephoneService telephoneService;
    @Autowired
    AddressesService addressesService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    CartsService cartService;
    @Autowired
    OrderGoodsService orderGoodsService;
    @Autowired
    CartsService cartsService;

    @AttsInclude
    @CatalogInclude
    @RequestMapping(method = RequestMethod.GET)
    public String renderMyOrderPage() {
        Users sessionUser = (Users) request.getSession().getAttribute(Constants.SESSION_USER);
        Users user = usersService.getUsersById(sessionUser.getId());
        request.setAttribute(Constants.ADDRESSES, user.getAddresses());
        request.setAttribute(Constants.TELEPHONES, user.getTelephones());
        return "pages/order";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String makeOrder(String telephone, String address, String delivery, String payment) {
        Telephones tel = telephoneService.getTelephoneByString(telephone);
        Addresses add = addressesService.getAddressByString(address);
        Users user = usersService.getUsersById(((Users) request.getSession().getAttribute(Constants.SESSION_USER)).getId());
        SumAndCount sumOfCartByUserId = cartService.getSumAndCountOfCartByUserId(user);
        Float totalSum = sumOfCartByUserId.getSum();
        Integer totalCount = sumOfCartByUserId.getCount();
        Orders order = new Orders(new Date(), totalSum, totalCount, payment, delivery, user, add, tel);
        ordersService.addOrders(order);
        orderGoodsService.addOrderGoods(order, cartsService.getUsersCart(user));
        cartService.deleteCartsByUser(user);
        return "ok";
    }


    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteFromOrders(Long orderId) {
        ordersService.deleteOrder(orderId);
        return "ok";
    }
}
