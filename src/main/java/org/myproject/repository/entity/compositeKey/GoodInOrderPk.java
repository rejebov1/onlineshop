package org.myproject.repository.entity.compositeKey;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class GoodInOrderPk implements Serializable {

    protected Long order_id;
    protected Long product_id;
}

