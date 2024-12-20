package codingTest.test;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class ServiceImpl implements Service{
	
	private final Mapper mapper;
	
	public List<Organization> selectOrgList() {
		
		List<Organization> orgList = mapper.selectOrgList();
		
		return orgList;
		
	}

}
