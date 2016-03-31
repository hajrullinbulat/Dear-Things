package ru.dz.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dz.labs.model.*;
import ru.dz.labs.services.*;

import java.util.Date;
import java.util.List;


@Controller
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

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String renderMyOrderPage() {
        Users sessionUser = (Users) request.getSession().getAttribute("user");
        Users user = usersService.getUsersById(sessionUser.getId());
        request.setAttribute("addresses", user.getAddresses());
        request.setAttribute("telephones", user.getTelephones());
        request.getSession().setAttribute("sum",
                Float.valueOf(String.valueOf(cartService.getSumOfCartByUserId(user).get(0)))
        );
        return "pages/order";
    }

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String makeOrder(String telephone, String address, String delivery, String payment) {
        Telephones tel = telephoneService.getTelephoneByString(telephone);
        Addresses add = addressesService.getAddressByString(address);
        Users user = usersService.getUsersById(((Users) request.getSession().getAttribute("user")).getId());
        Float totalSum = Float.valueOf(String.valueOf(cartService.getSumOfCartByUserId(user).get(0)));
        List cart = (List) request.getSession().getAttribute("cart");
        Integer totalCount = cart.size();
        Orders order = new Orders(new Date(), totalSum, totalCount, payment, delivery, user, add, tel);
        ordersService.addOrders(order);
        orderGoodsService.addOrderGoods(order,cart);
        cartService.deleteCartsByUser(user);
        return "ok";
    }
}
