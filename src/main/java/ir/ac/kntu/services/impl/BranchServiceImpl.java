/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.services.impl;

import ir.ac.kntu.Dao.BranchRepository;
import ir.ac.kntu.Dao.impl.BranchRepositoryImpl;
import ir.ac.kntu.base.services.impl.BaseServiceImpl;
import ir.ac.kntu.domains.Branch;
import ir.ac.kntu.services.BranchService;

public class BranchServiceImpl extends BaseServiceImpl<Branch, Long, BranchRepository> implements BranchService {

    public BranchServiceImpl() {
        BranchRepository repository = new BranchRepositoryImpl();
        super.setRepository(repository);
    }

    public BranchServiceImpl(BranchRepository repository) {
        super(repository);
    }

}
