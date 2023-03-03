package kr.std.dh.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.std.dh.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	List<Item> findByItemNm(String ItemNm);
	
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
}