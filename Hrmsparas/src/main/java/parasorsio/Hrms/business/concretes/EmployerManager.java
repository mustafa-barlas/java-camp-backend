package parasorsio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import parasorsio.Hrms.business.abstracts.EmployerService;
import parasorsio.Hrms.core.utilities.Result.DataResult;
import parasorsio.Hrms.core.utilities.Result.Result;
import parasorsio.Hrms.core.utilities.Result.SuccessDataResult;
import parasorsio.Hrms.core.utilities.Result.SuccessResult;
import parasorsio.Hrms.dataAccess.abstracts.EmployerDao;
import parasorsio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();

	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult(" saved to employer");
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult(" update to employer");
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult(" deleted to employer");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<List<Employer>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Employer>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "employer");
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(sort));
	}

	@Override
	public DataResult<Employer> getByEmployerName(String employerName) {
		return new SuccessDataResult<Employer>(this.employerDao.getByEmployerName(employerName));
	}

	@Override
	public DataResult<Employer> getByEmployerId(int employerId) {
		return new SuccessDataResult<Employer>(this.employerDao.getByEmployerId(employerId));
	}

	@Override
	public DataResult<List<Employer>> getByEmployerPostigns(String employerPostigns) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmployerPostigns(employerPostigns));
	}

	@Override
	public DataResult<List<Employer>> getByEmployerPosition(String employerPosition) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmployerPosition(employerPosition));
	}

	@Override
	public DataResult<List<Employer>> getByEmployerNameContains(String employerName) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmployerNameContains(employerName));
	}

	@Override
	public DataResult<List<Employer>> getByEmployerNameStartsWith(String employerName) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmployerNameStartsWith(employerName));
	}
}
