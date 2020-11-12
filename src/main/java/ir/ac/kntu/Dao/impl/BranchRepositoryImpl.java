/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.Dao.impl;

import ir.ac.kntu.Dao.BranchRepository;
import ir.ac.kntu.base.repository.impl.BaseRepositoryImpl;
import ir.ac.kntu.domains.Branch;

public class BranchRepositoryImpl extends BaseRepositoryImpl<Branch, Long> implements BranchRepository {
    @Override
    protected Class<Branch> getEntityClass() {
        return Branch.class;
    }

}
