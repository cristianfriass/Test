package com.globalsit.test.volleycomun;

import android.location.Location;
import android.util.Log;

/*import com.globalsit.cordial.delivery.config.GlobalValue;
import com.globalsit.cordial.delivery.config.WebServiceConfig;
import com.globalsit.cordial.delivery.object.Account;
import com.globalsit.cordial.delivery.object.Banner;
import com.globalsit.cordial.delivery.object.Category;
import com.globalsit.cordial.delivery.object.City;
import com.globalsit.cordial.delivery.object.Comment;
import com.globalsit.cordial.delivery.object.Market;
import com.globalsit.cordial.delivery.object.Menu;
import com.globalsit.cordial.delivery.object.Offer;
import com.globalsit.cordial.delivery.object.OpenHour;
import com.globalsit.cordial.delivery.object.Order;
import com.globalsit.cordial.delivery.object.OrderGroup;
import com.globalsit.cordial.delivery.object.Setting;
import com.globalsit.cordial.delivery.object.Shop;
import com.globalsit.cordial.delivery.object.ShopOrder;
import com.globalsit.cordial.delivery.object.WAddress;
import com.globalsit.cordial.delivery.object.WFood;
import com.globalsit.cordial.delivery.object.WOpenHour;
import com.globalsit.cordial.delivery.object.WOrderDetail;
import com.globalsit.cordial.delivery.object.WOrderDetailFood;
import com.globalsit.cordial.delivery.object.WOrderItem;
import com.globalsit.cordial.delivery.object.WShop;
import com.google.android.gms.maps.model.LatLng;*/

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParserUtility {

    /**
     * code created by william
     * */
    /*
    public static ArrayList<Market> parseListMarkets(String json) {
        ArrayList<Market> marketArrayList = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            Market market;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                market = new Market();
                market.setMarket_id(item.getString(WebServiceConfig.KEY_MARKET_ID));
                market.setMarket_name(item.getString(WebServiceConfig.KEY_MARKET_NAME));
                market.setMarket_address(item.getString(WebServiceConfig.KEY_MARKET_ADDRESS));
                market.setMarket_city(item.getString(WebServiceConfig.KEY_MARKET_CITY));
                market.setMarket_description(item.getString(WebServiceConfig.KEY_MARKET_DESCRIPTION));
                market.setMarket_thumbnail(item.getString(WebServiceConfig.KEY_MARKET_THUMBNAIL));
                market.setMarket_latitude(item.getString(WebServiceConfig.KEY_MARKET_LATITUDE));
                market.setMarket_longitude(item.getString(WebServiceConfig.KEY_MARKET_LONGITUDE));
                marketArrayList.add(market);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return marketArrayList;
    }

    public static ArrayList<Category> parseListCategoryMarkets(String json) {
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            Category category;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                category = new Category();
                category.setId(item.getString(WebServiceConfig.KEY_CATEGORY_ID));
                category.setName(item.getString(WebServiceConfig.KEY_CATEGORY_NAME));
                category.setDescription(item.getString(WebServiceConfig.KEY_CATEGORY_DESCRIPTION));
                category.setImage(item.getString(WebServiceConfig.KEY_CATEGORY_IMAGE));
                categoryArrayList.add(category);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categoryArrayList;
    }

    public static ArrayList<WShop> parseListShopByMarket(String json) {
        ArrayList<WShop> shopArrayList = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            WShop shop;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                shop = new WShop();
                shop.setShop_id(item.getString(WebServiceConfig.KEY_SHOP_ID));
                shop.setShop_name(item.getString(WebServiceConfig.KEY_SHOP_NAME));
                shop.setShop_address(item.getString(WebServiceConfig.KEY_SHOP_ADDRESS));
                shop.setShop_tel(item.getString(WebServiceConfig.KEY_SHOP_PHONE));
                shop.setShop_thumbnail(item.getString(WebServiceConfig.KEY_SHOP_IMAGE));
                shop.setShop_description(item.getString(WebServiceConfig.KEY_SHOP_DESCRIPTION));
                shop.setShop_latitude(item.getString(WebServiceConfig.KEY_SHOP_LATITUDE));
                shop.setShop_longitude(item.getString(WebServiceConfig.KEY_SHOP_LONGITUDE));
                shop.setShop_city(item.getString(WebServiceConfig.KEY_SHOP_CITY));

                //cargamos los FOOD(comidas)
                JSONArray foods = item.getJSONArray(WebServiceConfig.KEY_FOODS);
                ArrayList<WFood> foodArrayList = parseListFoodArray(foods);
                shop.setFoods(foodArrayList);
                shopArrayList.add(shop);
                //cargamos los shopOpenHour
                JSONObject openHour = item.getJSONObject(WebServiceConfig.KEY_SHOP_OPEN_HOUR);
                WOpenHour open_hour = parseOpenHour(openHour);
                shop.setShop_open_hour(open_hour);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return shopArrayList;
    }

    public static ArrayList<WFood> parseListFoodArray(JSONArray foods){
        ArrayList<WFood> result = new ArrayList<>();
        JSONObject item_food;
        WFood food;
        for (int y = 0; y < foods.length(); y++ ){
            try {
                item_food = foods.getJSONObject(y);
                food = new WFood();
                food.setFood_id(item_food.getString(WebServiceConfig.KEY_FOOD_ID));
                food.setFood_code(item_food.getString(WebServiceConfig.KEY_FOOD_CODE));
                food.setFood_name(item_food.getString(WebServiceConfig.KEY_FOOD_NAME));
                food.setFood_price(item_food.getString(WebServiceConfig.KEY_FOOD_PRICE));
                food.setFood_percent_discount(item_food.getInt(WebServiceConfig.KEY_FOOD_PERCENT_DISCOUNT));
                food.setFood_shop(item_food.getString(WebServiceConfig.KEY_FOOD_SHOP));
                food.setFood_category(item_food.getString(WebServiceConfig.KEY_CATEGORY_ID));
                food.setFood_thumbnail(item_food.getString(WebServiceConfig.KEY_FOOD_THUMBNAIL));
                food.setFood_description(item_food.getString(WebServiceConfig.KEY_FOOD_DESCRIPTION));
                food.setStatus(item_food.getString(WebServiceConfig.KEY_STATUS));
                food.setRate(item_food.getString(WebServiceConfig.KEY_RATE));
                food.setRate_times(item_food.getString(WebServiceConfig.KEY_RATE_TIMES));
                result.add(food);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static  WOpenHour parseOpenHour(JSONObject openHour){
        WOpenHour open_hour = new WOpenHour();
            try {
                open_hour.setDateId(openHour.getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_DATE_ID));
                open_hour.setDateName(openHour.getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_DATE_NAME));
                open_hour.setOpenAM(openHour.getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_OPEN_AM));
                open_hour.setCloseAM(openHour.getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_CLOSE_AM));
                open_hour.setOpenPM(openHour.getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_OPEN_PM));
                open_hour.setClosePM(openHour.getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_CLOSE_PM));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return open_hour;
    }
    public static ArrayList<WFood> parseListFood_W(String json) {
        ArrayList<WFood> arrFood = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray foods = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item_food;
            WFood food;
            for (int i = 0; i < foods.length(); i++) {
                item_food = foods.getJSONObject(i);
                food = new WFood();
                food.setFood_id(item_food.getString(WebServiceConfig.KEY_FOOD_ID));
                food.setFood_code(item_food.getString(WebServiceConfig.KEY_FOOD_CODE));
                food.setFood_name(item_food.getString(WebServiceConfig.KEY_FOOD_NAME));
                food.setFood_price(item_food.getString(WebServiceConfig.KEY_FOOD_PRICE));
                food.setFood_percent_discount(item_food.getInt(WebServiceConfig.KEY_FOOD_PERCENT_DISCOUNT));
                food.setFood_shop(item_food.getString(WebServiceConfig.KEY_FOOD_SHOP));
                food.setFood_category(item_food.getString(WebServiceConfig.KEY_FOOD_MENU));
                food.setFood_thumbnail(item_food.getString(WebServiceConfig.KEY_FOOD_THUMBNAIL));
                food.setFood_description(item_food.getString(WebServiceConfig.KEY_FOOD_DESCRIPTION));
                food.setStatus(item_food.getString(WebServiceConfig.KEY_STATUS));
                food.setRate(item_food.getString(WebServiceConfig.KEY_RATE));
                food.setRate_times(item_food.getString(WebServiceConfig.KEY_RATE_TIMES));
                food.setPrecios(item_food.getString(WebServiceConfig.KEY_FOOD_PRECIOS));
                food.setPrecios_nombre(item_food.getString(WebServiceConfig.KEY_FOOD_PRECIOS_NOMBRE));
                food.setTitulo_opcional(item_food.getString(WebServiceConfig.KEY_FOOD_TITULO_OPCIONAL));
                food.setOpcional(item_food.getString(WebServiceConfig.KEY_FOOD_OPCIONAL));
                food.setTitulo_extras(item_food.getString(WebServiceConfig.KEY_FOOD_TITULO_EXTRAS));
                food.setExtras_nombres(item_food.getString(WebServiceConfig.KEY_FOOD_EXTRAS_NOMBRES));
                food.setExtras_precios(item_food.getString(WebServiceConfig.KEY_FOOD_EXTRAS_PRECIOS));

                arrFood.add(food);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.e("error", "Parsed list food false");
        }
        return arrFood;
    }

    public static ArrayList<WAddress> parseListAddress_W(String json) {
        ArrayList<WAddress> addresses = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray array_address = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            WAddress address;
            for (int i = 0; i < array_address.length(); i++) {
                item = array_address.getJSONObject(i);
                address = new WAddress();
                address.setAddress_id(item.getString(WebServiceConfig.KEY_ADDRESS_ID));
                address.setAccount_id(item.getString(WebServiceConfig.KEY_ORDER_ACCOUT_ID));
                address.setAddress(item.getString(WebServiceConfig.KEY_ADDRESS));
                address.setReference(item.getString(WebServiceConfig.KEY_ADDRESS_REFERENCE));
                address.setLatitude(item.getString(WebServiceConfig.KEY_ADDRESS_LATITUDE));
                address.setLongitude(item.getString(WebServiceConfig.KEY_ADDRESS_LONGITUDE));
                address.setName(item.getString(WebServiceConfig.KEY_ADDRESS_NAME));
                addresses.add(address);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.e("error", "Parsed list food false");
        }
        return addresses;
    }

    public static ArrayList<WOrderItem> parseListOrder_W(String json) {
        ArrayList<WOrderItem> orderItems = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray array_orders = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            WOrderItem orderItem;
            for (int i = 0; i < array_orders.length(); i++) {
                item = array_orders.getJSONObject(i);
                orderItem = new WOrderItem();
                orderItem.setGroup_code(item.getString(WebServiceConfig.KEY_ORDER_ITEM_GROUP_CODE));
                orderItem.setShop_name(item.getString(WebServiceConfig.KEY_ORDER_ITEM_SHOP_NAME));
                orderItem.setTotal(item.getString(WebServiceConfig.KEY_ORDER_ITEM_TOTAL));
                orderItem.setDetail(item.getString(WebServiceConfig.KEY_ORDER_ITEM_ORDER_REQUIREMENT));
                orderItem.setTime(item.getString(WebServiceConfig.KEY_ORDER_ITEM_TIME));
                orderItem.setStatus(item.getString(WebServiceConfig.KEY_ORDER_ITEM_STATUS));
                orderItem.setImage_url(item.getString(WebServiceConfig.KEY_ORDER_ITEM_SHOP_THUMBNAIL));
                orderItems.add(orderItem);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.e("error", "Parsed list food false");
        }
        return orderItems;
    }

    public static WOrderDetail parseOrderDetail_W(String json) {
        WOrderDetail orderDetail = new WOrderDetail();
        try {
            JSONObject object_json = new JSONObject(json);
            JSONArray object_array = object_json.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject object = object_array.getJSONObject(0);

            orderDetail.setOrder_id(object.getString(WebServiceConfig.KEY_OD_ORDER_ID));
            orderDetail.setAccount_id(object.getString(WebServiceConfig.KEY_OD_ACCOUNT_ID));
            orderDetail.setShop_id(object.getString(WebServiceConfig.KEY_OD_SHOP_ID));
            orderDetail.setShop_name(object.getString(WebServiceConfig.KEY_OD_SHOP_NAME));
            orderDetail.setShop_thumbnail(object.getString(WebServiceConfig.KEY_OD_SHOP_THUMBNAIL));
            orderDetail.setAddress(object.getString(WebServiceConfig.KEY_OD_ADDRESS));
            orderDetail.setReference(object.getString(WebServiceConfig.KEY_OD_REFERENCE));
            orderDetail.setTotal(object.getString(WebServiceConfig.KEY_OD_TOTAL));
            orderDetail.setTax(object.getString(WebServiceConfig.KEY_OD_TAX));
            orderDetail.setShipping(object.getString(WebServiceConfig.KEY_OD_SHIPPING));
            orderDetail.setGrand_total(object.getString(WebServiceConfig.KEY_OD_GRAND_TOTAL));
            orderDetail.setOrder_time(object.getString(WebServiceConfig.KEY_OD_ORDER_TIME));
            orderDetail.setCreated(object.getString(WebServiceConfig.KEY_OD_CREATED));
            orderDetail.setOrder_status(object.getString(WebServiceConfig.KEY_OD_ORDER_STATUS));
            orderDetail.setNit_ci(object.getString(WebServiceConfig.KEY_OD_NIT_CI));
            orderDetail.setRazon_social(object.getString(WebServiceConfig.KEY_OD_RAZON_SOCIAL));
            orderDetail.setDetalles(object.getString(WebServiceConfig.KEY_OD_DETALLES));
            orderDetail.setPayment_status(object.getString(WebServiceConfig.KEY_OD_PAYMENT_STATUS));
            orderDetail.setPayment_method(object.getString(WebServiceConfig.KEY_OD_PAYMENT_METHOD));

            //cargamos los FOOD DETAILS(comidas)
            JSONArray foods = object.getJSONArray(WebServiceConfig.KEY_OD_FOODS);
            List<WOrderDetailFood> foodArrayList = parseListDetailFoodArray(foods);
            orderDetail.setFoods(foodArrayList);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orderDetail;
    }

    public static List<WOrderDetailFood> parseListDetailFoodArray(JSONArray json_array) {
        List<WOrderDetailFood> result = new ArrayList<>();
        JSONObject item_food;
        WOrderDetailFood orderDetailFood;
        for (int y = 0; y < json_array.length(); y++ ){
            try {
                item_food = json_array.getJSONObject(y);
                orderDetailFood = new WOrderDetailFood();

                orderDetailFood.setFood_id(item_food.getString(WebServiceConfig.KEY_ODF_FOOD_ID));
                orderDetailFood.setNumber(item_food.getString(WebServiceConfig.KEY_ODF_NUMBER));
                orderDetailFood.setPrice(item_food.getString(WebServiceConfig.KEY_ODF_PRICE));
                orderDetailFood.setDetail_food(item_food.getString(WebServiceConfig.KEY_ODF_DETAIL_FOOD));
                orderDetailFood.setFood_code(item_food.getString(WebServiceConfig.KEY_ODF_FOOD_CODE));
                orderDetailFood.setFood_name(item_food.getString(WebServiceConfig.KEY_ODF_FOOD_NAME));
                orderDetailFood.setFood_menu(item_food.getString(WebServiceConfig.KEY_ODF_FOOD_MENU));
                orderDetailFood.setFood_thumbnail(item_food.getString(WebServiceConfig.KEY_ODF_FOOD_THUMBNAIL));
                orderDetailFood.setFood_description(item_food.getString(WebServiceConfig.KEY_ODF_FOOD_DESCRIPTION));
                orderDetailFood.setStatus(item_food.getString(WebServiceConfig.KEY_ODF_STATUS));
                orderDetailFood.setTotal_item(item_food.getString(WebServiceConfig.KEY_ODF_TOTAL_ITEM));
                orderDetailFood.setOpcional(item_food.getString(WebServiceConfig.KEY_ODF_OPCIONAL));
                orderDetailFood.setExtras(item_food.getString(WebServiceConfig.KEY_ODF_EXTRAS));

                result.add(orderDetailFood);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //OLD CODIGO
    // account


    public static ArrayList<Menu> parseListFood(String json) {
        ArrayList<Menu> arrFood = new ArrayList<Menu>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            Menu food;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                food = new Menu();
                food.setId(item.getInt(WebServiceConfig.KEY_FOOD_ID));
                food.setCode(item.getString(WebServiceConfig.KEY_FOOD_CODE));
                food.setName(item.getString(WebServiceConfig.KEY_FOOD_NAME));
                food.setDescription(item
                        .getString(WebServiceConfig.KEY_FOOD_DESCRIPTION));
                food.setImage(item.getString(WebServiceConfig.KEY_FOOD_THUMBNAIL));
                food.setPrice(item.getDouble(WebServiceConfig.KEY_FOOD_PRICE));
                food.setPercentDiscount(item
                        .getDouble(WebServiceConfig.KEY_FOOD_PERCENT_DISCOUNT));
                food.setShopId(item.getInt(WebServiceConfig.KEY_FOOD_SHOP));
                food.setCategoryId(item.getInt(WebServiceConfig.KEY_CATEGORY_ID));
                try {
                    food.setRateValue(Float.parseFloat(item
                            .getString(WebServiceConfig.KEY_RATE)));
                } catch (Exception ex) {
                    food.setRateValue(0);
                }
                try {
                    food.setRateNumber(Integer.parseInt(item
                            .getString(WebServiceConfig.KEY_RATE_TIMES)));
                } catch (Exception ex) {
                    food.setRateNumber(0);
                }

                arrFood.add(food);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.e("error", "Parsed list food false");
        }

        return arrFood;
    }
    public static Account parseAccount(String json) {
        Account account = null;
        try {
            JSONObject object = new JSONObject(json);
            if (object.getString(WebServiceConfig.KEY_STATUS).equalsIgnoreCase(
                    WebServiceConfig.KEY_STATUS_SUCCESS)) {
                JSONObject item = object
                        .getJSONObject(WebServiceConfig.KEY_DATA);
                account = new Account();
                account.setId(item.getString(WebServiceConfig.KEY_ACCOUNT_ID));
                account.setUserName(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_USER_NAME));
                account.setEmail(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_EMAIL));
                account.setFull_name(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_FULL_NAME));
                account.setPhone(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_PHONE));
                account.setCelular(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_CELULAR));
                account.setReferencias(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_REFERENCIAS));
                account.setAddress(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_ADDRESS));
                account.setRole(item
                        .getString(WebServiceConfig.KEY_ACCOUNT_ROLE));
                account.setRedirectLink(item.getString(WebServiceConfig.KEY_ACCOUNT_REDIRECT_LINK));
                //check requestShopOwner
                if (!item.isNull(WebServiceConfig.KEY_ACCOUNT_REQUEST_SHOP_OWNER)) {
                    account.setIsRequestShopOwner(item.getInt(WebServiceConfig.KEY_ACCOUNT_REQUEST_SHOP_OWNER) == 1);
                }
                account.setRazon_social(item.getString(WebServiceConfig.KEY_ACCOUNT_RAZON_SOCIAL));
                account.setNit(item.getString(WebServiceConfig.KEY_ACCOUNT_NIT));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return account;
    }

    // offer
    public static ArrayList<Offer> parseListOffer(String json) {
        ArrayList<Offer> arrOffers = new ArrayList<Offer>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;

            Offer offer;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);

                offer = new Offer();
                offer.setOfferId(item.getInt(WebServiceConfig.KEY_OFFER_ID));
                offer.setShopId(item.getInt(WebServiceConfig.KEY_SHOP_ID));
                offer.setDescription(item
                        .getString(WebServiceConfig.KEY_OFFER_DESCRIPTION));
                offer.setImage(item.getString(WebServiceConfig.KEY_OFFER_IMAGE));
                offer.setEndDate(item
                        .getString(WebServiceConfig.KEY_OFFER_END_DATE));
                offer.setEndTime(item
                        .getString(WebServiceConfig.KEY_OFFER_END_TIME));

                arrOffers.add(offer);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrOffers;
    }

    public static ArrayList<OrderGroup> parseListOrderGroup(String json) {
        ArrayList<OrderGroup> arrOffers = new ArrayList<OrderGroup>();
        try {
            JSONObject object = new JSONObject(json);

            JSONObject item;
            OrderGroup oder;

            if (!object.isNull(WebServiceConfig.KEY_DATA)) {
                JSONArray arrjson = object
                        .getJSONArray(WebServiceConfig.KEY_DATA);

                for (int i = 0; i < arrjson.length(); i++) {
                    item = arrjson.getJSONObject(i);
                    oder = new OrderGroup();
                    if (!item.isNull("code"))
                        oder.setId(item.getString("code"));
                    if (!item.isNull("total"))
                        oder.setPrice(item.getDouble("total"));
                    if (!item.isNull("time"))
                        oder.setDatetime(item.getString("time"));
                    if (!item.isNull("status"))
                        oder.setStatus(item.getString("status"));

                    arrOffers.add(oder);
                }
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrOffers;
    }

    public static ArrayList<ShopOrder> parseListShopOrder(String json) {
        ArrayList<ShopOrder> arrOffers = new ArrayList<ShopOrder>();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject item, jsonFood;
            JSONArray arrjson, arrFoodJson;
            ShopOrder shopOrder = null;
            ArrayList<Menu> arrFoods;
            Menu food;

            if (!object.isNull(WebServiceConfig.KEY_DATA)) {
                arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);

                for (int i = 0; i < arrjson.length(); i++) {
                    // parse shop order
                    item = arrjson.getJSONObject(i);
                    shopOrder = new ShopOrder();
                    if (!item.isNull("order_id"))
                        shopOrder.setOrderId(item.getString("order_id"));
                    if (!item.isNull("account_id"))
                        shopOrder.setAccountId(item.getString("account_id"));
                    if (!item.isNull("shop_name"))
                        shopOrder.setShopName(item.getString("shop_name"));
                    if (!item.isNull("shop_thumbnail"))
                        shopOrder
                                .setShopImage(item.getString("shop_thumbnail"));
                    if (!item.isNull("order_places"))
                        shopOrder.setOrderAddress(item
                                .getString("order_places"));
                    if (!item.isNull("total"))
                        shopOrder.setTotalPrice(item.getDouble("total"));
                    if (!item.isNull("tax"))
                        shopOrder.setVAT(item.getDouble("tax"));
                    if (!item.isNull("shipping"))
                        shopOrder.setShipping(item.getDouble("shipping"));
                    if (!item.isNull("grandTotal"))
                        shopOrder.setGrandTotal(item.getDouble("grandTotal"));
                    if (!item.isNull("order_time"))
                        shopOrder.setOrderTime(item.getString("order_time"));
                    if (!item.isNull("orderStatus")) {
                        shopOrder.setOrderStatus(item.getInt("orderStatus"));
                        GlobalValue.KEY_ORDER_STATUS=item.getString("orderStatus");
                    }
                    if (!item.isNull("paymentStatus"))
                        shopOrder
                                .setPaymentStatus(item.getInt("paymentStatus"));
                    if (!item.isNull("paymentMethod"))
                        shopOrder
                                .setPaymentMethod(item.getInt("paymentMethod"));

                    // parse list food
                    arrFoodJson = item.getJSONArray("foods");
                    arrFoods = new ArrayList<Menu>();
                    int size = arrFoodJson.length();
                    for (int j = 0; j < size; j++) {
                        jsonFood = arrFoodJson.getJSONObject(j);
                        food = new Menu();
                        food.setId(jsonFood.getInt("food_id"));
                        food.setOrderNumber(jsonFood.getInt("number"));
                        food.setPrice(jsonFood.getDouble("price"));
                        food.setCode(jsonFood.getString("food_code"));
                        food.setName(jsonFood.getString("food_name"));
                        food.setCategoryId(jsonFood.getInt("food_menu"));
                        food.setImage(jsonFood.getString("food_thumbnail"));
                        food.setDescription(jsonFood
                                .getString("food_description"));
                        arrFoods.add(food);
                    }
                    shopOrder.setArrFoods(arrFoods);
                    arrOffers.add(shopOrder);
                }

            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.e("huy-log", "list-shop-order : " + e.getMessage());
            e.printStackTrace();

        }

        return arrOffers;
    }

    public static ArrayList<Order> parseListOrder(String json) {
        ArrayList<Order> arrOffers = new ArrayList<Order>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;

            Order oder;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);

                oder = new Order();
                oder.setPlacesO(item.getString("order_places"));
                oder.setStatusO(item.getString("orderStatus"));
                oder.setO_id(item.getString("order_id"));
                oder.setSttO(item.getString("count"));
                oder.setTimeO(item.getString("created"));
                oder.setTotalO(item.getString("total"));

                arrOffers.add(oder);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrOffers;
    }

    public static ArrayList<Order> parseListDetailOrder(String json) {
        ArrayList<Order> arrOffers = new ArrayList<Order>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;

            Order oder;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);

                oder = new Order();
                oder.setName(item.getString("food_name"));
                oder.setImage(item.getString("food_thumbnail"));
                oder.setNumber(item.getString("number"));
                oder.setPrice(item.getString("price"));
                oder.setPromotion(item.getString("promotion"));

                arrOffers.add(oder);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrOffers;
    }

    public static Offer parseOffer(String json) {
        Offer offer = new Offer();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject item = object.getJSONObject(WebServiceConfig.KEY_DATA);

            offer.setOfferId(item.getInt(WebServiceConfig.KEY_OFFER_ID));
            offer.setShopId(item.getInt(WebServiceConfig.KEY_SHOP_ID));
            offer.setDescription(item
                    .getString(WebServiceConfig.KEY_OFFER_DESCRIPTION));
            offer.setImage(item.getString(WebServiceConfig.KEY_OFFER_IMAGE));
            offer.setEndDate(item
                    .getString(WebServiceConfig.KEY_OFFER_END_DATE));
            offer.setEndTime(item
                    .getString(WebServiceConfig.KEY_OFFER_END_TIME));

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return offer;
    }

    // shop
    public static ArrayList<Shop> getListShop(String json) {
        ArrayList<Shop> arrShop = new ArrayList<Shop>();
        try {
            JSONObject object = new JSONObject(json);
            Shop shop;
            JSONObject item;
            JSONArray arr = object.getJSONArray(WebServiceConfig.KEY_DATA);
            if (arr.length() > 0) {
                for (int i = 0; i < arr.length(); i++) {
                    item = arr.getJSONObject(i);
                    shop = new Shop();
                    shop.setShopId(item.getInt(WebServiceConfig.KEY_SHOP_ID));
                    shop.setShopName(item
                            .getString(WebServiceConfig.KEY_SHOP_NAME));
                    shop.setAddress(item
                            .getString(WebServiceConfig.KEY_SHOP_ADDRESS));
                    shop.setPhone(item
                            .getString(WebServiceConfig.KEY_SHOP_PHONE));
                    shop.setImage(item
                            .getString(WebServiceConfig.KEY_SHOP_IMAGE));
                    shop.setDescription(item
                            .getString(WebServiceConfig.KEY_SHOP_DESCRIPTION));
                    shop.setLatitude(item
                            .getDouble(WebServiceConfig.KEY_SHOP_LATITUDE));
                    shop.setLongitude(item
                            .getDouble(WebServiceConfig.KEY_SHOP_LONGITUDE));
                    shop.setCityId(item.getInt(WebServiceConfig.KEY_SHOP_CITY));
                    shop.setIsVerified(item.getString("isVerified"));
                    shop.setIsFeatured(item.getString("isFeatured"));
                    shop.setFacebook(item.getString("facebook"));
                    shop.setTwitter(item.getString("twitter"));
                    shop.setEmail(item.getString("email"));
                    shop.setLive_chat(item.getString("live_chat"));

                    try {
                        shop.setRateNumber(Integer.parseInt(item
                                .getString(WebServiceConfig.KEY_RATE_TIMES)));
                    } catch (Exception ex) {
                        shop.setRateNumber(0);
                    }
                    try {
                        shop.setRateValue(Float.parseFloat(item
                                .getString(WebServiceConfig.KEY_RATE)));
                    } catch (Exception ex) {
                        shop.setRateValue(0);
                    }

//                    JSONObject arrOpenhour = item
//                            .getJSONObject(WebServiceConfig.KEY_SHOP_OPEN_HOUR);
//                    OpenHour openhour = new OpenHour();
//                    openhour.setOpenAM(arrOpenhour
//                            .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_OPEN_AM));
//                    openhour.setOpenPM(arrOpenhour
//                            .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_OPEN_PM));
//                    openhour.setCloseAM(arrOpenhour
//                            .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_CLOSE_AM));
//                    openhour.setClosePM(arrOpenhour
//                            .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_CLOSE_PM));
//                    openhour.setShopId(shop.getShopId());
//
//                    shop.setOpenHour(openhour);

                    //is open or close
                    if (!item.isNull("is_open"))
                        shop.setIsOpen(item.getString("is_open").equals("1"));

                    // get VAT
                    if (!item.isNull("shop_vat"))
                        shop.setShopVAT(item.getDouble("shop_vat"));

                    // get delivery cost
                    if (!item.isNull("shop_transport_fee")) {
                        JSONObject jsonShip = item
                                .getJSONObject("shop_transport_fee");
                        shop.setMinPriceForDelivery(jsonShip
                                .getDouble("minimum"));
                        shop.setDeliveryPrice(jsonShip
                                .getDouble("shipping_fee"));

                        Location locationA = new Location("Negocio");
                        locationA.setLatitude(item.getDouble(WebServiceConfig.KEY_SHOP_LATITUDE));
                        locationA.setLongitude(item.getDouble(WebServiceConfig.KEY_SHOP_LONGITUDE));

                        Location locationB = new Location("Domicilio");
                        locationB.setLatitude(GlobalValue.glatlng.latitude);
                        locationB.setLongitude(GlobalValue.glatlng.longitude);

                        double distancia_km = Math.floor((locationA.distanceTo(locationB)/1000));
                        double costo_envio=8+distancia_km;



                        shop.setDeliveryPrice(costo_envio);
                    }

                    arrShop.add(shop);
                }
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return arrShop;
    }

    public static Shop parseShop(String json) {
        JSONObject object;
        Shop shop = null;
        try {
            object = new JSONObject(json);
            JSONObject item = object.getJSONObject(WebServiceConfig.KEY_DATA);
            shop = new Shop();
            shop.setShopId(item.getInt(WebServiceConfig.KEY_SHOP_ID));
            shop.setShopName(item.getString(WebServiceConfig.KEY_SHOP_NAME));
            shop.setAddress(item.getString(WebServiceConfig.KEY_SHOP_ADDRESS));
            shop.setPhone(item.getString(WebServiceConfig.KEY_SHOP_PHONE));
            shop.setImage(item.getString(WebServiceConfig.KEY_SHOP_IMAGE));
            shop.setDescription(item
                    .getString(WebServiceConfig.KEY_SHOP_DESCRIPTION));
            shop.setLatitude(item.getDouble(WebServiceConfig.KEY_SHOP_LATITUDE));
            shop.setLongitude(item
                    .getDouble(WebServiceConfig.KEY_SHOP_LONGITUDE));
            shop.setCityId(item.getInt(WebServiceConfig.KEY_SHOP_CITY));
            shop.setFacebook(item.getString("facebook"));
            shop.setTwitter(item.getString("twitter"));
            shop.setEmail(item.getString("email"));
            shop.setLive_chat(item.getString("live_chat"));
            try {
                shop.setRateNumber(item
                        .getInt(WebServiceConfig.KEY_RATE_TIMES));
            } catch (Exception ex) {
                shop.setRateNumber(0);
            }
            try {
                shop.setRateValue(item.getInt(WebServiceConfig.KEY_RATE));
            } catch (Exception ex) {
                shop.setRateValue(0);
            }

            // get all banner
            JSONArray bannerJS = item
                    .getJSONArray(WebServiceConfig.KEY_SHOP_BANNERS);
            ArrayList<Banner> arrBanner = new ArrayList<Banner>();
            Banner banner;
            JSONObject itemBannerJs;
            for (int i = 0; i < bannerJS.length(); i++) {
                itemBannerJs = bannerJS.getJSONObject(i);
                banner = new Banner();
                banner.setId(itemBannerJs
                        .getInt(WebServiceConfig.KEY_BANNER_ID));
                banner.setName(itemBannerJs
                        .getString(WebServiceConfig.KEY_BANNER_NAME));
                banner.setImage(itemBannerJs
                        .getString(WebServiceConfig.KEY_BANNER_IMAGE));

                banner.setShopId(shop.getShopId());

                arrBanner.add(banner);
            }

            shop.setArrBanner(arrBanner);

            //is open or close
            if (!item.isNull("is_open"))
                shop.setIsOpen(item.getString("is_open").equals("1"));

            // get VAT
            if (!item.isNull("shop_vat"))
                shop.setShopVAT(item.getDouble("shop_vat"));

            // get delivery cost
            if (!item.isNull("shop_transport_fee")) {

                JSONObject jsonShip = item.getJSONObject("shop_transport_fee");
                shop.setMinPriceForDelivery(jsonShip.getDouble("minimum"));
                shop.setDeliveryPrice(jsonShip.getDouble("shipping_fee"));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return shop;
    }

    // open hour

    public static ArrayList<OpenHour> parseListOpenHour(String json) {
        // get all openhour
        JSONObject item;
        ArrayList<OpenHour> arrOpenHour = new ArrayList<>();
        try {
            item = new JSONObject(json);
            JSONArray openhourJS = item.getJSONArray(WebServiceConfig.KEY_DATA);
            OpenHour openhour;
            JSONObject itemOpenhourJs;
            for (int i = 0; i < openhourJS.length(); i++) {
                itemOpenhourJs = openhourJS.getJSONObject(i);
                openhour = new OpenHour();
                openhour.setDateId(itemOpenhourJs
                        .getInt(WebServiceConfig.KEY_SHOP_OPEN_HOUR_DATE_ID));
                openhour.setDateName(itemOpenhourJs
                        .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_DATE_NAME));
                openhour.setOpenAM(itemOpenhourJs
                        .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_OPEN_AM));
                openhour.setOpenPM(itemOpenhourJs
                        .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_OPEN_PM));
                openhour.setCloseAM(itemOpenhourJs
                        .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_CLOSE_AM));
                openhour.setClosePM(itemOpenhourJs
                        .getString(WebServiceConfig.KEY_SHOP_OPEN_HOUR_CLOSE_PM));

                arrOpenHour.add(openhour);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return arrOpenHour;
    }

    // city

    public static ArrayList<City> parseListCity(String json) {
        ArrayList<City> arrCities = new ArrayList<City>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            City city;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                city = new City();
                city.setId(item.getInt(WebServiceConfig.KEY_CITY_ID));
                city.setPostCode(item
                        .getString(WebServiceConfig.KEY_CITY_POST_CODE));
                city.setName(item.getString(WebServiceConfig.KEY_CITY_NAME));

                arrCities.add(city);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrCities;
    }

    // categories

    public static ArrayList<Category> parseListCategories(String json) {
        ArrayList<Category> arrCategories = new ArrayList<Category>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            Category category;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                category = new Category();
                category.setId(item.getString(WebServiceConfig.KEY_CATEGORY_ID));
                category.setName(item
                        .getString(WebServiceConfig.KEY_CATEGORY_NAME));
                category.setDescription(item
                        .getString(WebServiceConfig.KEY_CATEGORY_DESCRIPTION));
                category.setImage(item
                        .getString(WebServiceConfig.KEY_CATEGORY_IMAGE));

                arrCategories.add(category);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrCategories;
    }
    public static ArrayList<Category> parseListCategories2(String json) {
        ArrayList<Category> arrCategories = new ArrayList<Category>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            Category category;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                category = new Category();
                category.setId(item.getString(WebServiceConfig.KEY_CATEGORY_ID));
                category.setName(item
                        .getString(WebServiceConfig.KEY_CATEGORY_NAME));
                category.setDescription(item
                        .getString(WebServiceConfig.KEY_CATEGORY_DESCRIPTION));
                category.setImage(item
                        .getString(WebServiceConfig.KEY_CATEGORY_IMAGE));
                category.setcity_id(item
                        .getInt(WebServiceConfig.KEY_CITY_ID));

                arrCategories.add(category);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return arrCategories;
    }

    public static Category parseCategory(String json) {
        Category category = new Category();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject item = object.getJSONObject(WebServiceConfig.KEY_DATA);

            category.setId(item.getString(WebServiceConfig.KEY_CATEGORY_ID));
            category.setName(item.getString(WebServiceConfig.KEY_CATEGORY_NAME));
            category.setDescription(item
                    .getString(WebServiceConfig.KEY_CATEGORY_DESCRIPTION));
            category.setImage(item
                    .getString(WebServiceConfig.KEY_CATEGORY_IMAGE));

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return category;
    }

    public static ArrayList<Menu> parseListFoodInSearch(String json) {
        ArrayList<Menu> arrFood = new ArrayList<Menu>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray arrjson = object.getJSONArray(WebServiceConfig.KEY_DATA);
            JSONObject item;
            Menu food;
            for (int i = 0; i < arrjson.length(); i++) {
                item = arrjson.getJSONObject(i);
                food = new Menu();
                food.setId(item.getInt(WebServiceConfig.KEY_FOOD_ID));
                food.setCode(item.getString(WebServiceConfig.KEY_FOOD_CODE));
                food.setName(item.getString(WebServiceConfig.KEY_FOOD_NAME));
                food.setLocalName(item.getString(WebServiceConfig.KEY_SHOP_NAME));
                food.setDescription(item
                        .getString(WebServiceConfig.KEY_FOOD_DESCRIPTION));
                food.setImage(item.getString(WebServiceConfig.KEY_FOOD_THUMBNAIL));
                food.setPrice(item.getDouble(WebServiceConfig.KEY_FOOD_PRICE));
                food.setPercentDiscount(item
                        .getDouble(WebServiceConfig.KEY_FOOD_PERCENT_DISCOUNT));
                food.setShopId(item.getInt(WebServiceConfig.KEY_FOOD_SHOP));
                food.setCategoryId(item.getInt(WebServiceConfig.KEY_CATEGORY_ID));
                food.setCategory(item.getString("category"));
                food.setShop_address(item.getString("shop_address"));
                food.setShop_phone(item.getString("shop_phone"));
                try {
                    food.setRateValue(Float.parseFloat(item
                            .getString(WebServiceConfig.KEY_RATE)));
                } catch (Exception ex) {
                    food.setRateValue(0);
                }
                try {
                    food.setRateNumber(Integer.parseInt(item
                            .getString(WebServiceConfig.KEY_RATE_TIMES)));
                } catch (Exception ex) {
                    food.setRateNumber(0);
                }

                arrFood.add(food);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.e("error", "Parsed list food false");
        }

        return arrFood;
    }

    public static Menu parseFood(String json) {
        Menu food = null;
        try {
            JSONObject object = new JSONObject(json);
            JSONObject item = object.getJSONObject(WebServiceConfig.KEY_DATA);
            food = new Menu();
            food.setId(item.getInt(WebServiceConfig.KEY_FOOD_ID));
            food.setCode(item.getString(WebServiceConfig.KEY_FOOD_CODE));
            food.setName(item.getString(WebServiceConfig.KEY_FOOD_NAME));
            food.setDescription(item
                    .getString(WebServiceConfig.KEY_FOOD_DESCRIPTION));
            food.setImage(item.getString(WebServiceConfig.KEY_FOOD_THUMBNAIL));
            food.setPercentDiscount(item
                    .getDouble(WebServiceConfig.KEY_FOOD_PERCENT_DISCOUNT));
            food.setPrice(item.getDouble(WebServiceConfig.KEY_FOOD_PRICE));
            food.setShopId(item.getInt(WebServiceConfig.KEY_FOOD_SHOP));
            food.setCategoryId(item.getInt(WebServiceConfig.KEY_CATEGORY_ID));
            try {
                food.setRateValue(Float.parseFloat(item
                        .getString(WebServiceConfig.KEY_RATE)));
            } catch (Exception ex) {
                food.setRateValue(0);
            }
            try {
                food.setRateNumber(Integer.parseInt(item
                        .getString(WebServiceConfig.KEY_RATE_TIMES)));
            } catch (Exception ex) {
                food.setRateNumber(0);
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return food;
    }

    public static Setting parseSetting(String json) {
        Setting setting = new Setting();

        try {

            JSONObject item;
            JSONObject jsonObject = new JSONObject(json);
            JSONArray itemService = jsonObject
                    .getJSONArray(WebServiceConfig.KEY_DATA);
            for (int i = 0; i < itemService.length(); i++) {
                item = itemService.getJSONObject(i);
                setting.setVat(item.getString(WebServiceConfig.KEY_VAT));
                setting.setTransportFee(item
                        .getString(WebServiceConfig.KEY_SHIP));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return setting;

    }

    public static ArrayList<Comment> parseComments(String json) {
        ArrayList<Comment> arrComment = new ArrayList<Comment>();

        if (json != null) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                if (jsonObject.getString(WebServiceConfig.KEY_STATUS)
                        .equalsIgnoreCase(WebServiceConfig.KEY_STATUS_SUCCESS)) {
                    JSONArray jsonArr = jsonObject
                            .getJSONArray(WebServiceConfig.KEY_DATA);
                    if (jsonArr != null && jsonArr.length() > 0) {
                        for (int i = 0; i < jsonArr.length(); i++) {
                            JSONObject obj = jsonArr.getJSONObject(i);

                            Comment cmt = new Comment();
                            cmt.setContent(obj.getString("content"));
                            cmt.setCreatedDate(obj.getString("created"));
                            cmt.setRateValue(Float.parseFloat(obj
                                    .getString("rate")));
                            cmt.setUserID(obj.getString("account_id"));

                            arrComment.add(cmt);
                        }
                    }
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return arrComment;
    }

    public static String convertAccountToJsonString(Account acc) {
        String str = "";
        if (acc.getId().isEmpty()) {
            JSONObject json = new JSONObject();
            try {
                json.put("id", acc.getId());
                json.put("userName", acc.getUserName());
                json.put("fullName", acc.getFull_name());
                json.put("email", acc.getEmail());
                json.put("address", acc.getAddress());
                json.put("phone", acc.getPhone());
                json.put("pass", acc.getPassword());
                json.put("role", acc.getRole());
                json.put("redirectLink", acc.getRedirectLink());
                json.put("loginType", acc.getType());

                str = json.toString();

            } catch (JSONException e) {
                str = "";
            }
        }
        return str;
    }

    public static Account convertJsonStringtoAccount(String json) {
        Account account = null;
        if (json.isEmpty()) {
            try {
                account = new Account();
                JSONObject jsonObj = new JSONObject(json);
                account.setId(jsonObj.getString("id"));
                account.setUserName(jsonObj.getString("userName"));
                account.setFull_name(jsonObj.getString("fullName"));
                account.setEmail(jsonObj.getString("email"));
                account.setAddress(jsonObj.getString("address"));
                account.setPhone(jsonObj.getString("phone"));
                account.setPassword(jsonObj.getString("pass"));
                account.setRole(jsonObj.getString("role"));
                account.setRedirectLink(jsonObj.getString("redirectLink"));
                account.setType(jsonObj.getString("loginType"));

            } catch (JSONException e) {
                account = null;
            }
        }
        return account;
    }

    public static LatLng parseDefaultLocation(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return new LatLng(object.getJSONObject("data").getDouble("lat"), object.getJSONObject("data").getDouble("lon"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new LatLng(0.0000000, 0.0000000);
        }
    }
    public static String parseCelular(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return new String(object.getJSONObject("data").getString("Celular"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new String("70716145");
        }
    }
    public static String parseFijo(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return new String(object.getJSONObject("data").getString("Fijo"));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new String("70716145");
        }
    }

    public static boolean isSuccess(String json) {
        try {
            JSONObject object = new JSONObject(json);
            if (object.getString(WebServiceConfig.KEY_STATUS).equals(WebServiceConfig.KEY_STATUS_SUCCESS)) {
                return true;
            } else {
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getAllPageCount(String json) {
        int pageCount = 0;
        try {
            JSONObject object = new JSONObject(json);
            if (!object.isNull("allpage")) {
                pageCount = object.getInt("allpage");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return pageCount;
    }*/

    // Mi Codigo



}
