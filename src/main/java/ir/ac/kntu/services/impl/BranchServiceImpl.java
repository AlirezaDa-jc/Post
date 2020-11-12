package ir.ac.kntu.services.impl;

import ir.ac.kntu.Dao.BranchRepository;
import ir.ac.kntu.Dao.impl.BranchRepositoryImpl;
import ir.ac.kntu.base.services.impl.BaseServiceImpl;
import ir.ac.kntu.domains.Branch;
import ir.ac.kntu.services.BranchService;

public class BranchServiceImpl extends BaseServiceImpl<Branch, Long, BranchRepository> implements BranchService {
//    private static List<Route> routes;
//    private static Route route;
    public BranchServiceImpl() {
        BranchRepository repository = new BranchRepositoryImpl();
        super.setRepository(repository);
    }
//
    public BranchServiceImpl(BranchRepository repository) {
        super(repository);
    }
//
//    public static Route getRoute() {
//        return route;
//    }
//
//    public static void setRoute(Route route) {
//        BranchServiceImpl.route = route;
//    }
//
//    public static List<Route> getRoutes() {
//        return routes;
//    }
//
//    public void setRoutes(List<Route> routes) {
//        BranchServiceImpl.routes = routes;
//    }
//
//    @Override
//    public List<Route> findAll(){
//        routes = baseRepository.findAll();
//        return routes;
//    }
//
//    @Override
//    public List<Route> findRoutes(Route route) {
//        routes = baseRepository.findAll().stream()
//                .sorted(Comparator.comparing(Route::getTime))
//                .filter((c) -> c.equals(route))
//                .collect(Collectors.toList());
//        if(routes.size() == 0 ){
//            routes = null;
//        }
//        return routes;
//    }
}
