package codingTest.test;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

	List<Organization> selectOrgList();

}
