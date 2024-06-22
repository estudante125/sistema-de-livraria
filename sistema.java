import java.sql.*;

public class GerenteDeLivraria {
    private Connection conexao;

    public GerenteDeLivraria(String url, String usuario, String senha) throws SQLException {
        this.conexao = DriverManager.getConnection(url, usuario, senha);
    }

    public void cadastrarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros (titulo, autor_id, preco) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAutor().getId());
            stmt.setDouble(3, livro.getPreco());
            stmt.executeUpdate();
        }
    }

    public Livro consultarLivro(int id) throws SQLException {
        String sql = "SELECT * FROM livros WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Livro livro = new Livro();
                    livro.setId(rs.getInt("id"));
                    livro.setTitulo(rs.getString("titulo"));
                    Autor autor = consultarAutor(rs.getInt("autor_id"));
                    livro.setAutor(autor);
                    livro.setPreco(rs.getDouble("preco"));
                    return livro;
                }
            }
        }
        return null;
    }

    public void atualizarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livros SET titulo = ?, autor_id = ?, preco = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAutor().getId());
            stmt.setDouble(3, livro.getPreco());
            stmt.setInt(4, livro.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirLivro(int id) throws SQLException {
        String sql = "DELETE FROM livros WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Autor consultarAutor(int id) throws SQLException {
        String sql = "SELECT * FROM autores WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Autor autor = new Autor();
                    autor.setId(rs.getInt("id"));
                    autor.setNome(rs.getString("nome"));
                    autor.setEmail(rs.getString("email"));
                    return autor;
                }
            }
        }
        return null;
    }

    public void cadastrarAutor(Autor autor) throws SQLException {
        String sql = "INSERT INTO autores (nome, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getEmail());
            stmt.executeUpdate();
        }
    }

    public void atualizarAutor(Autor autor) throws SQLException {
        String sql = "UPDATE autores SET nome = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getEmail());
            stmt.setInt(3, autor.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirAutor(int id) throws SQLException {
        String sql = "DELETE FROM autores WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Cliente consultarCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setTelefone(rs.getString("telefone"));
                    return cliente;
                }
            }
        }
        return null;
    }

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, telefone) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.executeUpdate();
        }
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirCliente(int id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
