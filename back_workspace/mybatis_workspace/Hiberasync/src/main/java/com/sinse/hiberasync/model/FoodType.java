package com.sinse.hiberasync.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/** [ORM - Object Relation(관계형 DB) Mapping, 테이블-java객체 매핑]
 * JPA는 java의 자체 API에서 지원하는 인터페이스
 * hibernate 사설로 JPA를 구현한 구현체, 표준은 아님
 */
@Data
@Entity
@Table(name="food_type")
public class FoodType {
	@Id
	private int food_type_id;
	private String title;
}
