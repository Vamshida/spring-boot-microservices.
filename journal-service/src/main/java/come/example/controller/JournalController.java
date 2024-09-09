@RestController
@RequestMapping("/journals")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping
    public ResponseEntity<List<Journal>> getJournals() {
        return new ResponseEntity<>(journalService.getAllJournals(), HttpStatus.OK);
    }
}
