-- ====================================================================
-- plugin.example DB schema (v1) — smoke test for PluginDatabase API
-- + onSourceImported hook.
-- Created on first plugin attachment to a project.
-- ${table:import_log} → plugin_com_velitask_plugin_example_import_log.
-- ====================================================================

CREATE TABLE IF NOT EXISTS ${table:import_log} (
    source_id INTEGER PRIMARY KEY,
    source_path TEXT NOT NULL,
    processed_at INTEGER NOT NULL
);
