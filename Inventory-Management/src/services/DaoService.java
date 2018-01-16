package services;
import java.util.List;

import models.Item;

public interface DaoService {
public boolean create(String[] splitStr);
public boolean delete(String[] splitStr);
public boolean updateBuy(String[] splitStr);
public boolean updateSell(String[] splitStr);
public boolean updateSellPrice(String[] splitStr);
public List<Item> report(String[] splitStr);
}
