package com.example.chuabai;

import com.example.chuabai.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerSpec implements Specification<Customer> {

    private CustomerRequest customerRequest;

    public CustomerSpec(CustomerRequest customerRequest)  {
        this.customerRequest = customerRequest;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {

        if(customerRequest.getFirstName() != null){
            query.where(
                    criteriaBuilder.
                            like(root.get("firstName"),
                                    "%" + customerRequest.getFirstName() + "%")
            );
        }

        return query.getRestriction();
    }
}
