@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @KafkaListener(topics = "user-events", groupId = "user-group")
    public void consumeEvent(String message) {
        Journal journal = new Journal();
        journal.setMessage(message);
        journalRepository.save(journal);
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }
}
