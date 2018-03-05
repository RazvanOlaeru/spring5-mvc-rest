package guru.springfamework.controllers.v1;


import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {

    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"", "/"})
    public VendorListDTO getAllVendors() {
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id:[\\d]+}")
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = {"", "/"}, params = "name")
    public VendorDTO getVendorByName(@RequestParam(name = "name") String name) {
        return vendorService.getVendorByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping({"", "/"})
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id:[\\d]+}")
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id:[\\d]+}")
    public VendorDTO patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.patchVendor(id, vendorDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id:[\\d]+}")
    public void deleteVendor(@PathVariable Long id) {

        vendorService.deleteVendorById(id);

    }
}
