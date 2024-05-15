
CREATE TABLE partai (
    id UUID PRIMARY KEY,
    nama_partai VARCHAR(255) NOT NULL
);

CREATE TABLE dapil (
    id UUID PRIMARY KEY,
    nama_dapil VARCHAR(255) NOT NULL,
    provinsi VARCHAR(255) NOT NULL
);

CREATE TABLE caleg (
    id UUID PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    nomor_urut INT NOT NULL,
    partai_id UUID,
    dapil_id UUID,
    FOREIGN KEY (partai_id) REFERENCES partai(id),
    FOREIGN KEY (dapil_id) REFERENCES dapil(id)
);

CREATE TABLE wilayah_dapil (
    id UUID PRIMARY KEY,
    nama_wilayah VARCHAR(255) NOT NULL,
    dapil_id UUID,
    FOREIGN KEY (dapil_id) REFERENCES dapil(id)
);