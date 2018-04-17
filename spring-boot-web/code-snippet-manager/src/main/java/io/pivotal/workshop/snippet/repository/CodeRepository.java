package io.pivotal.workshop.snippet.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.pivotal.workshop.snippet.domain.Code;

@Repository
public class CodeRepository implements SimpleRepository<Code>{

	private List<Code> codes = new ArrayList<>();

	public List<Code> findAll() {
		return codes;
	}

	@Override
	public void save(Collection<Code> items) {
		this.codes.addAll(items);
	}

	@Override
	public Code save(Code item) {
		assert item.getSource() != null;
		
		Code code = findOne(item.getId());
		
		if(code == null){
			this.codes.add(item);
			return item;
		}
		else {
			code.setSource(item.getSource());
			return code;
		}
	}

	@Override
	public Code findOne(String id) {
		Optional<Code> code = codes
				.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst();
		if (code.isPresent()) return code.get();
		
		return null;
	}

	
}
