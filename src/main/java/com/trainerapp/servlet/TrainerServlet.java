package com.trainerapp.servlet;

import com.trainerapp.model.Trainer;
import com.trainerapp.dao.TrainerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Transactional
@WebServlet(urlPatterns = "/trainer")
public class TrainerServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(TrainerServlet.class);

    @Inject
    private TrainerDao trainerDao;

    private void addTrainer() {
    }

    private void updateTrainer() {
    }

    private void deleteTrainer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Long id = Long.parseLong(req.getParameter("id"));
        LOG.info("Removing Trainer with id = {}", id);

        trainerDao.delete(id);

        // Return all persisted objects
        findAll(req, resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Trainer> result = trainerDao.findAll();
        LOG.info("Found {} objects", result.size());
        for (Trainer p : result) {
            resp.getWriter().write(p.toString() + "\n");
        }
    }

}
