package br.com.codenation.aplicacao.jobs;

import br.com.codenation.aplicacao.domain.dao.CompanyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;



@Component
public class ApplicationJobs {

    Logger LOG = LoggerFactory.getLogger(ApplicationJobs.class);

    @Autowired
    private CompanyDao companyDao;

    @Scheduled(fixedRate = 5000)
    public void listCompany(){
        LOG.info("#### START VERIFY COUNT COMPANIES");
        LOG.info("#### FOUND {} COMPANIES IN BASE", companyDao.count());
        LOG.info("#### END VERIFY COUNT COMPANIES");
    }

}
